package tree;

import tree.uniqueconstraints.UniqueConstraintViolationException;
import tree.uniqueconstraints.UniqueTreeConstraint;
import tree.util.QueryBuilderUtil;
import tree.util.TreeActionLocation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jabrik on 20/11/2014.
 */
public abstract class AbstractTreeDao<N extends  TreeNode> implements TreeDao<N> {
    protected final DBSession session;
    private final String nodeEntityName;
    private UniqueTreeConstraint<N> uniqueTreeConstraint;
    private boolean checkUniqueConstraintOnUpdate  = false;
    private CopiedNodeRenamer<N> copiedNodeRenamer;

    protected AbstractTreeDao(DBSession session, String nodeEntityName) {
        assert session != null;
        this.session = session;
        this.nodeEntityName  = nodeEntityName;
    }

    @Override
    public boolean isPersistent(N entity) {
        return entity.getId() != null;
    }

    protected Object save(N node) {
        return session.save(node);
    }

    public boolean equal(N n1, N n2) {
        return (n1 == n2) ? true : (n1 == null || n2 == null) ? false : n1.equals(n2);
    }

    @Override
    public void setUniqueTreeConstraint(UniqueTreeConstraint<N> uniqueTreeConstraint) {
        this.uniqueTreeConstraint = uniqueTreeConstraint;
    }

    @Override
    public void setCheckUniqueConstraintUpdate(boolean checkUniqueConstraintUpdate) {
        this.checkUniqueConstraintOnUpdate = checkUniqueConstraintUpdate;
    }

    protected final boolean shouldCheckUniqueConsraintOnUpdate() {
        return checkUniqueConstraintOnUpdate;
    }

    protected final UniqueTreeConstraint<N> getUniqueTreeConstraint() {
        return uniqueTreeConstraint;
    }

    @Override
    public void checkUniqueConstraint(N cloneOfExistingNodeWithNewValues, N root, N existingNode) throws UniqueConstraintViolationException {
        TreeActionLocation<N> location = new TreeActionLocation<N>(root, null, existingNode, TreeActionLocation.ActionType.UPDATE);
        List<N> clones = new ArrayList<N>();
        clones.add(cloneOfExistingNodeWithNewValues);
        checkUniqueness(clones, location);
    }

    protected void checkUniqueness(List<N> nodes, TreeActionLocation<N> location) throws UniqueConstraintViolationException{
        if(getUniqueTreeConstraint() == null)
            return;
        assert nodes != null && nodes.size() >= 1 && location != null : "Need node and location to check unique constraint!";

        getUniqueTreeConstraint().setContext(session, this, nodeEntityName, pathEntityName());
        if (getUniqueTreeConstraint().checkUniqueConstraint(nodes, location) == false) {
            String message = "One of the following entities is not unique :"+ nodes;
            @SuppressWarnings("unchecked")
            N clone = (N) nodes.get(0).clone();
            throw new UniqueConstraintViolationException(message, clone);
        }

    }

    @Override
    public void setCopiedNodeRenamer(CopiedNodeRenamer<N> copiedNodeRenamer) {
        this.copiedNodeRenamer = copiedNodeRenamer;
    }

    protected final void applyCopiedNodeRenamer(N node) {
        if(copiedNodeRenamer != null)
            copiedNodeRenamer.renameCopiedNode(node);
    }

    protected final String nodeEntityName() {
        return nodeEntityName;
    }

    protected String pathEntityName() {
        return null;
    }

    protected void assertUpdate(N node) {
        if(isPersistent(node) == false)
            throw new IllegalArgumentException("Entity is not persistent!, Use addChild() for " + node);
    }

    protected void copyOrMovePreconditions(N relativeNode, N nodeToMove) {
        if(relativeNode != null && isPersistent(relativeNode) == false || isPersistent(nodeToMove) == false)
            throw new IllegalArgumentException("node not in tree, or has no root");
        if(relativeNode != null && isChildOf(relativeNode, nodeToMove))
            throw new IllegalArgumentException("Target node is in subtree of source node; target=" + relativeNode + ", source=" + nodeToMove);

    }

    protected void refresh(List<?> nodesToRefresh) {
        session.flush();
        for (Object nodeToRefresh : nodesToRefresh)
            session.refresh(nodeToRefresh);
    }

    protected final void beforeFindQuery(String tableAlias,StringBuilder queryText, List<Object> parameters, boolean whereWasAppended, boolean doNotApplyTemporalConditions, boolean invertTemporalConditions) {
        if (invertTemporalConditions == true) {
            queryText.append(whereWasAppended ? " and " : " where ");
            appendInvalidityCondition(tableAlias, queryText, parameters);
        }
        else if (doNotApplyTemporalConditions == false) {
            queryText.append(whereWasAppended ? " and " : " where ");
            appendValidityCondition(tableAlias, queryText, parameters);
        }
    }

    protected void appendInvalidityCondition(String tableAlias, StringBuilder queryText, List<Object> parameters) {
        if(getValidToPropertyName() == null)
            throw new IllegalArgumentException("Please override appendInvalidityCondition when validToPropertyName is null");
        final String validToPropertyName = buildAliasedPropertyName(tableAlias, getValidToPropertyName());
        queryText.append(validToPropertyName + " is not null and " + validToPropertyName + " <= " + buildIndexPlaceHolder(parameters));
        parameters.add(validTo());
    }

    public void appendValidityCondition(String tableAlias, StringBuilder queryText, List<Object> parameters) {
            if(getValidToPropertyName() == null)
                throw new IllegalArgumentException("Please ovveride appendValidityCondition when validToPropertyName is null");
        QueryBuilderUtil.appendValidityConditions(tableAlias, getValidFromPropertyName(), validFrom(), getValidToPropertyName(), validTo(), queryText, parameters);
    }

    protected final String buildAliasedPropertyName(String tableAlias, String propertyName) {
        return QueryBuilderUtil.buildAliasedPropertyName(tableAlias, propertyName);
    }

    protected final String buildIndexPlaceHolder(List<Object> parameters) {
        return QueryBuilderUtil.buildIndexedPlaceHolder(parameters);
    }

    protected Date validFrom() {
        return new Date();
    }
    protected Date validTo() {
        return new Date();
    }
    protected Date validToOnRemove() {
        return new Date();
    }

    public boolean isValid(Temporal node, Date validityDate) {
        return (node.getValidFrom() == null || node.getValidFrom().before(validityDate) || node.getValidFrom().equals(validityDate)) &&
                (node.getValidTo() == null || node.getValidTo().after(validityDate));
    }
    protected String getValidFromPropertyName() {
        throw new RuntimeException("Must override this for temporal DAO");
    }

    protected  String getValidToPropertyName() {
        throw new RuntimeException("Must ovverride this for temporal DAO");
    }


}
