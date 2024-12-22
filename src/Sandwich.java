public class Sandwich implements Nutritious
{
    private String filling1;
    private String filling2;

    public Sandwich(String filling1, String filling2)
    {
        this.filling1 = filling1;
        this.filling2 = filling2;
    }

    public String getFilling1()
    {
        return filling1;
    }

    public String getFilling2()
    {
        return filling2;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Sandwich sandwich = (Sandwich) obj;
        return filling1.equals(sandwich.filling1) && filling2.equals(sandwich.filling2);
    }

    @Override
    public int calculateCalories()
    {
        int calories = 0;
        calories += getCalories(filling1);
        calories += getCalories(filling2);
        return calories;
    }

    private int getCalories(String filling)
    {
        switch (filling.toLowerCase())
        {
            case "ham":
                return 150;
            case "cheese":
                return 100;
            case "turkey":
                return 120;
            case "lettuce":
                return 10;
            default:
                return 50;
        }
    }
}