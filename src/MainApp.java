
public class MainApp {
    public static void main(String[] args) {
        MotorInfo info = new MotorInfo("Vonny", "Yamaha NMAX", 6, 120000);

        MotorRental rental = new MotorRental(info);

        rental.calculateTotal();
    }
}
