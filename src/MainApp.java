/**
 * Kelas MainApp berfungsi sebagai titik awal menjalankan program.
 */
public class MainApp {

    public static void main(String[] args) {

        // Menentukan harga otomatis berdasarkan jenis motor
        String motorDipilih = "Yamaha NMAX";   // bisa diganti menjadi motor lain
        double hargaPerHari = MotorRental.getRateByMotorType(motorDipilih);

        MotorInfo info = new MotorInfo("Vonny", motorDipilih, 6, hargaPerHari);

        MotorRental rental = new MotorRental(info);
        rental.calculateTotal();
    }
}