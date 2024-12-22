import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Sandwich> sandwiches = new ArrayList<>();

        try {
            Class<?> sandwichClass = Class.forName("Sandwich");
            Constructor<?> constructor = sandwichClass.getConstructor(String.class, String.class);
            sandwiches.add((Sandwich) constructor.newInstance("Ham", "Cheese"));
            sandwiches.add((Sandwich) constructor.newInstance("Turkey", "Lettuce"));
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            System.out.println("Продукт не может быть включен в завтрак: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Breakfast breakfast = new Breakfast(sandwiches);


        List<String> parameters = Arrays.asList(args);

        if (parameters.contains("-calories")) {
            System.out.println("Total calories in breakfast: " + breakfast.totalCalories());
        }

        if (parameters.contains("-sort")) {
            breakfast.sort();
            System.out.println("Sorted breakfast: " + sandwiches);
        }
    }
}
