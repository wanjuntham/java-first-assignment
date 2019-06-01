import java.util.Scanner;

public class Assignment{
    public static int cartCount = 0;
    public String ram = "";
    public String screen = ""; 
    public String ssd = "";
    public String processor = "";
    static Assignment laptop1 = null;
    static Assignment laptop2 = null;
    static int totalPrice = 1000;
    public static void main(String[] args) {
        boolean isBuilding = true;
        String promoCode = "";
        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard2 = new Scanner(System.in);
        System.out.println("");
        System.out.println("Welcome to Laptop Builder Program! The base price of laptop will have a base price of RM1000.");
        System.out.println("Please enter the value accordingly showed in the round brackets.");
        checkCart();

        System.out.println("Please specify how many laptops do you want to buy:(max. 2)");
        cartCount = keyboard.nextInt();
        while (isBuilding){
            if (cartCount == 1) {
                System.out.println("Please further select your components: ");
                laptop1 = new Assignment();
                laptop1.screen = laptop1.laptopScreen();
                laptop1.ram = laptop1.laptopRam();
                laptop1.ssd = laptop1.laptopSsd();
                laptop1.processor = laptop1.laptopProcessor();
                isBuilding = false;
            } else if (cartCount ==2) {
                System.out.println("Please further select your components for first laptop: ");
                laptop1 = new Assignment();
                laptop1.screen = laptop1.laptopScreen();
                laptop1.ram = laptop1.laptopRam();
                laptop1.ssd = laptop1.laptopSsd();
                laptop1.processor = laptop1.laptopProcessor();
                laptop2 = new Assignment();
                laptop2.screen = laptop2.laptopScreen();
                laptop2.ram = laptop2.laptopRam();
                laptop2.ssd = laptop2.laptopSsd();
                laptop2.processor = laptop2.laptopProcessor();
                isBuilding = false;
            } else {
                System.out.println("See you soon, goodbye!");
                isBuilding = false;
                System.exit(0);
            }
        }

        checkCart();
        System.out.println("Do you have a promo code? Please key in now and type no if you do not have a promo code:");
        promoCode = keyboard2.nextLine();
        checkPromoCode(promoCode);
        
        System.out.println("Total price is RM" + totalPrice);
        System.out.println("Thanks for using my laptop builder program!");
        
    }

    void doneLaptop(){
        System.out.println(screen + ram);
        System.out.println("");
    }

    String laptopScreen(){
        Scanner keyboard = new Scanner(System.in);
        String screen = "";
        System.out.println("What do you want for the laptop screen? 1080p, 4K, or touchscreen?(1080p,4k,touchscreen)");
        screen = keyboard.nextLine();
        return screen;
    }

    String laptopRam(){
        Scanner keyboard = new Scanner(System.in);
        String ram = "";
        System.out.println("How many GB of rams would you need? 8GB, 16GB or 32GB? (8,16,32)");
        ram = keyboard.nextLine();
        return ram;
    }

    String laptopSsd(){
        Scanner keyboard = new Scanner(System.in);
        String ssd = "";
        System.out.println("How many GB of SSD storage would you need? 128GB, 256GB or 512GB?(128,256,512)");
        ssd = keyboard.nextLine();
        return ssd;
    }

    String laptopProcessor(){
        Scanner keyboard = new Scanner(System.in);
        String processor = "";
        System.out.println("Which type of processor would you need? i3 8100, i5 9600k or i7 9700k? (i3,i5,i7)");
        processor = keyboard.nextLine();
        return processor;
    }

    int calculateTotal(String screen, String ram, String ssd, String processor){
        int screenTemp = 0;
        int ramTemp = 0;
        int ssdTemp = 0;
        int processorTemp = 0;

        if (screen.equals("4k")){
            screenTemp = 500;
        } else if (screen.equals("touchscreen")){
            screenTemp = 300;
        }

        if (ram.equals("16")){
            ramTemp = 300;
        } else if (ram.equals("32")){
            ramTemp = 700;
        }

        if (ssd.equals("256")){
            ssdTemp = 100;
        } else if (ssd.equals("512")) {
            ssdTemp = 250;
        }

        if (processor.equals("i5")){
            processorTemp = 300;
        } else if (processor.equals("i7")){
            processorTemp = 700;
        }
        return screenTemp + ramTemp + ssdTemp + processorTemp;
    }

    static void checkCart(){
        if (cartCount == 0) {
            System.out.println("Your cart is empty, lets build a laptop");
        } else if (cartCount == 1){
            totalPrice += laptop1.calculateTotal(laptop1.screen, laptop1.ram, laptop1.ssd, laptop1.processor);
            System.out.println("The total price for your shopping cart is RM" + totalPrice);
            System.out.println("Below is the spec of your laptop:");
            System.out.println("Screen: "+ laptop1.screen);
            System.out.println("RAM: "+ laptop1.ram + "GB");
            System.out.println("SSD: "+ laptop1.ssd + "GB");
            System.out.println("Processor: " + laptop1.processor);
        } else if (cartCount == 2){
            totalPrice += laptop1.calculateTotal(laptop1.screen, laptop1.ram, laptop1.ssd, laptop1.processor);
            totalPrice += laptop2.calculateTotal(laptop2.screen, laptop2.ram, laptop2.ssd, laptop2.processor);
            System.out.println("The total price for your shopping cart is RM" + totalPrice);
            System.out.println("Below is the spec of your first laptop:");
            System.out.println("Screen: "+ laptop1.screen);
            System.out.println("RAM: "+ laptop1.ram + "GB");
            System.out.println("SSD: "+ laptop1.ssd + "GB");
            System.out.println("Processor: " + laptop1.processor);
            System.out.println("");
            System.out.println("Below is the spec for your second laptop:");
            System.out.println("Screen: "+ laptop2.screen);
            System.out.println("RAM: "+ laptop2.ram + "GB");
            System.out.println("SSD: "+ laptop2.ssd + "GB");
            System.out.println("Processor: " + laptop2.processor);
        }
            
    }

    static void checkPromoCode(String promoCode){
        boolean isPromoCode = true;
        do {
            if (promoCode.equals("DISCOUNT10")){
                totalPrice = totalPrice * 90 / 100;
                isPromoCode = false;
            } else if (promoCode.equals("DISCOUNT20")){
                totalPrice = totalPrice *80 / 100;
                isPromoCode = false;
            } else if (promoCode.equals("no")){
                System.out.println("No promo code");
                isPromoCode = false;
            } else {
                System.out.println("Invalid promo code, please try again.");
                isPromoCode = false;
            }
        } while (isPromoCode);
        
        
            
        
    }
}