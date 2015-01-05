package tree;

import java.util.Date;

/**
 * Created by Jabrik on 20/11/2014.
 */
public interface Temporal {
    String VALID_FROM = "validFrom";
    String VALID_TO = "validTo";

    Date getValidTo();

    void setValidTo(Date validTo);
    Date getValidFrom();

    void setValidFrom(Date validFrom);
}
