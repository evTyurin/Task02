package by.tc.task01.entity.criteria;

public final class SearchCriteria {

    public static final String REFRIGERATOR = "Refrigerator";
    public static final String OVEN = "Oven";

    public static enum Oven{
        POWER_CONSUMPTION, WEIGHT, CAPACITY, DEPTH, HEIGHT, WIDTH
    }

    public static enum Refrigerator{
        POWER_CONSUMPTION, WEIGHT, FREEZER_CAPACITY, OVERALL_CAPACITY, HEIGHT, WIDTH
    }

    private SearchCriteria() {}
}
