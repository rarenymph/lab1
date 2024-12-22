import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Breakfast
{
    private List<Sandwich> sandwiches;

    public Breakfast(List<Sandwich> sandwiches)
    {
        this.sandwiches = sandwiches;
    }

    public int countSandwiches(Sandwich targetSandwich)
    {
        int count = 0;
        for (Sandwich sandwich : sandwiches)
        {
            if (sandwich.equals(targetSandwich))
            {
                count++;
            }
        }
        return count;
    }

    public int totalCalories()
    {
        int total = 0;
        for (Sandwich sandwich : sandwiches)
        {
            total += sandwich.calculateCalories();
        }
        return total;
    }

    public void sort()
    {
        Collections.sort(sandwiches, new Comparator<Sandwich>() {
            @Override
            public int compare(Sandwich s1, Sandwich s2) {
                return s1.getFilling1().compareTo(s2.getFilling1());
            }
        });
    }
}