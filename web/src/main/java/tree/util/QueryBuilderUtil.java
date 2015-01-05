package tree.util;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Jabrik on 20/11/2014.
 */
public class QueryBuilderUtil {
    public static boolean appendCriteria(
            boolean nullIsACriterion,
            StringBuilder queryText,
            String tableAlias,
            List<Object> parameterValues,
            Map<String,Object> criteria,
            boolean whereWasAppended)
    {
        return appendCriteria(nullIsACriterion, queryText, tableAlias, parameterValues, criteria, whereWasAppended, true);
    }

    public static boolean appendCriteria(
            boolean nullIsACriterion,
            StringBuilder queryText,
            String tableAlias,
            List<Object> parameterValues,
            Map<String,Object> criteria,
            boolean whereWasAppended,
            boolean startWithWhereOrAnd)
    {
        if (criteria != null)	{
            for (Map.Entry<String,Object> criterion : criteria.entrySet())	{
                if (criterion.getValue() != null || nullIsACriterion)	{
                    if (startWithWhereOrAnd)
                        queryText.append(whereWasAppended ? " and " : " where ");

                    whereWasAppended = true;
                    startWithWhereOrAnd = true;

                    final String aliasedPropertyName = buildAliasedPropertyName(tableAlias, criterion.getKey());

                    if (criterion.getValue() != null)	{
                        queryText.append(aliasedPropertyName+" = "+buildIndexedPlaceHolder(parameterValues)+" ");
                        parameterValues.add(criterion.getValue());
                    }
                    else {	// nullIsACriterion == true
                        queryText.append(aliasedPropertyName+" is null ");
                    }
                }
            }
        }

        return whereWasAppended;
    }

    public static void appendValidityConditions(
            String tableAlias,
            String validFromPropertyName,
            Date validFrom,
            String validToPropertyName,
            Date validTo,
            StringBuilder queryText,
            List<Object> parameters)
    {
        final Date now = new Date();
        if (validFromPropertyName != null)	{
            validFromPropertyName = buildAliasedPropertyName(tableAlias, validFromPropertyName);
            queryText.append(" ("+validFromPropertyName+" is null or "+validFromPropertyName+" <= "+buildIndexedPlaceHolder(parameters)+") and ");
            parameters.add(validFrom != null ? validFrom : now);
        }
        validToPropertyName = buildAliasedPropertyName(tableAlias, validToPropertyName);
        queryText.append(" ("+validToPropertyName+" is null or "+validToPropertyName+" > "+buildIndexedPlaceHolder(parameters)+") ");
        parameters.add(validTo != null ? validTo : now);
    }

    public static String buildAliasedPropertyName(String tableAlias, String propertyName) {
        return (tableAlias != null ? tableAlias+"." : "")+propertyName;
    }

    public static String buildIndexedPlaceHolder(List<Object> parameters) {
        return "?"+(parameters.size() + 1);
    }
    private QueryBuilderUtil() {}
}
