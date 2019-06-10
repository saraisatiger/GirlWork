package girlwork.domain;

public enum RenewableType {
    WIND, SOLAR;

    public String toString() {
        switch(this) {
            case WIND:
                return "WIND";
            case SOLAR:
                return "SOLAR";
        }

        return null;
    }
}
