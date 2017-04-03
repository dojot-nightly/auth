package br.com.cpqd.platiot.user.to;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ActivePasswordTO implements Serializable {
    private String name = "";
    private String identifier = "";
    private Date initialDate;
    private Date finalDate;
    private UserTO customerTO;
    private boolean finalizing;
    private boolean finalized;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public UserTO getCustomerTO() {
        return customerTO;
    }

    public void setCustomerTO(UserTO customerTO) {
        this.customerTO = customerTO;
    }

    public boolean isFinalizing() {
        return finalizing;
    }

    public void setFinalizing(boolean finalizing) {
        this.finalizing = finalizing;
    }

    public boolean isFinalized() {
        return finalized;
    }

    public void setFinalized(boolean finalized) {
        this.finalized = finalized;
    }
}
