package models.Recipes;

import java.util.HashMap;
import java.util.Map;

public enum RecipeInfo {

    CHERRY_BOMB(1, "Cherry Bomb", "هرچیز در شعاع ۳ تایلی را نابود می‌کند", new HashMap<String, Integer>() {{
        put("Copper Ore", 4);
        put("Coal", 1);
    }}),

    BOMB(2, "Bomb", "هرچیز در شعاع  ۵ تایلی را نابود می‌کند", new HashMap<String, Integer>() {{
        put("Iron Ore", 4);
        put("Coal", 1);
    }}),

    MEGA_BOMB(3, "Mega Bomb", "هرچیز در شعاع ۷ تایلی را نابود می‌کند", new HashMap<String, Integer>() {{
        put("Gold Ore", 4);
        put("Coal", 1);
    }}),

    SPRINKLER(4, "Sprinkler", "به ۴ تایل مجاور آب می‌دهد", new HashMap<String, Integer>() {{
        put("Copper Bar", 1);
        put("Iron Bar", 1);
    }}),

    QUALITY_SPRINKLER(5, "Quality Sprinkler", "به ۸ تایل مجاور آب می‌دهد", new HashMap<String, Integer>() {{
        put("Iron Bar", 1);
        put("Gold Bar", 1);
    }}),

    IRIDIUM_SPRINKLER(6, "Iridium Sprinkler", "به ۲۴ تایل مجاور آب می‌دهد", new HashMap<String, Integer>() {{
        put("Gold Bar", 1);
        put("Iridium Bar", 1);
    }}),

    CHARCOAL_KILN(7, "Charcoal Kiln", "۱۰ چوب را تبدیل به ۱ ذغال می‌کند", new HashMap<String, Integer>() {{
        put("Wood", 20);
        put("Copper Bar", 2);
    }}),

    FURNACE(8, "Furnace", "کانی ها و ذغال را تبدیل به شمش می‌کند", new HashMap<String, Integer>() {{
        put("Copper Ore", 20);
        put("Stone", 25);
    }}),

    SCARECROW(9, "Scarecrow", "از حمله کلاغ ها تا شعاع ۸ تایلی جلوگیری می‌کند", new HashMap<String, Integer>() {{
        put("Wood", 50);
        put("Coal", 1);
        put("Fiber", 20);
    }}),

    DELUXE_SCARECROW(10, "Deluxe Scarecrow", "از حمله کلاغ ها تا شعاع 12 تایلی جلوگیری می‌کند", new HashMap<String, Integer>() {{
        put("Wood", 50);
        put("Coal", 1);
        put("Fiber", 20);
        put("Iridium Ore", 1);
    }}),

    BEE_HOUSE(11, "Bee House", "اگر در مزرعه گذاشته شود عسل تولید می‌کند", new HashMap<String, Integer>() {{
        put("Wood", 40);
        put("Coal", 8);
        put("Iron Bar", 1);
    }}),

    CHEESE_PRESS(12, "Cheese Press", "شیر را به پنیر تبدیل می‌کند", new HashMap<String, Integer>() {{
        put("Wood", 45);
        put("Stone", 45);
        put("Copper Bar", 1);
    }}),

    KEG(13, "Keg", "میوه و سبزیجات را به نوشیدنی تبدیل می‌کند", new HashMap<String, Integer>() {{
        put("Wood", 30);
        put("Copper Bar", 1);
        put("Iron Bar", 1);
    }}),

    LOOM(14, "Loom", "پشم را به پارچه تبدیل می‌کند", new HashMap<String, Integer>() {{
        put("Wood", 60);
        put("Fiber", 30);
    }}),

    MAYONNAISE_MACHINE(15, "Mayonnaise Machine", "تخم مرغ را به سس مایونز تبدیل می‌کند", new HashMap<String, Integer>() {{
        put("Wood", 15);
        put("Stone", 15);
        put("Copper Bar", 1);
    }}),

    OIL_MAKER(16, "Oil Maker", "truffle را به روغن تبدیل می‌کند", new HashMap<String, Integer>() {{
        put("Wood", 100);
        put("Gold Bar", 1);
        put("Iron Bar", 1);
    }}),

    PRESERVES_JAR(17, "Preserves Jar", "سبزیجات را به ترشی و میوه ها را به مربا تبدیل می‌کند", new HashMap<String, Integer>() {{
        put("Wood", 50);
        put("Stone", 40);
        put("Coal", 8);
    }}),

    DEHYDRATOR(18, "Dehydrator", "میوه یا قارچ را خشک می‌کند", new HashMap<String, Integer>() {{
        put("Wood", 30);
        put("Stone", 20);
        put("Fiber", 30);
    }}),

    GRASS_STARTER(19, "Grass Starter", "با گذاشتن آن روی زمین، در آن نقطه grass رشد می‌کند", new HashMap<String, Integer>() {{
        put("Wood", 1);
        put("Fiber", 1);
    }}),

    FISH_SMOKER(20, "Fish Smoker", "هر ماهی را با یک ذغال با حفظ کیفیتش تبدیل به ماهی دودی می‌کند", new HashMap<String, Integer>() {{
        put("Wood", 50);
        put("Iron Bar", 3);
        put("Coal", 10);
    }}),

    MYSTIC_TREE_SEED(21, "Mystic Tree Seed", "می‌تواند کاشته شود تا mystic tree رشد کند", new HashMap<String, Integer>() {{
        put("Acorn", 5);
        put("Maple Seed", 5);
        put("Pine Cone", 5);
        put("Mahogany Seed", 5);
    }});

    private final int id;
    private final String name;
    private final String description;
    private final Map<String, Integer> ingredients;

    RecipeInfo(int id, String name, String description, Map<String, Integer> ingredients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getIngredients() {
        return new HashMap<>(ingredients); // Return a copy to prevent modification
    }
}
