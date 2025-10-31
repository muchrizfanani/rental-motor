/**
 * Kelas MotorRental digunakan untuk menghitung total biaya sewa motor
 * berdasarkan lama sewa dan harga sewa per hari. Kelas ini juga menerapkan
 * diskon apabila lama sewa melebihi batas tertentu.
 */
public class MotorRental {

    /** Persentase diskon apabila lama sewa melebihi batas minimum */
    public static final double DISCOUNT_RATE = 0.1;

    /** Batas minimum hari sewa untuk mendapatkan diskon */
    public static final int DISCOUNT_THRESHOLD = 5;

    private String customerName;
    private String motorType;
    private int rentalDays;
    private double dailyRate;

    /**
     * Konstruktor untuk mengisi data sewa motor menggunakan objek MotorInfo.
     *
     * @param motorInfo berisi data penyewa, jenis motor, lama sewa, dan harga per hari
     */
    public MotorRental(MotorInfo motorInfo) {
        this.setCustomerName(motorInfo.customerName());
        this.setMotorType(motorInfo.motorType());
        this.setRentalDays(motorInfo.rentalDays());
        this.setDailyRate(motorInfo.dailyRate());
    }


    /**
     * Method baru untuk menentukan harga otomatis berdasarkan jenis motor.
     *
     * @param motorType jenis motor yang ingin disewa
     * @return harga sewa per hari
     */

    public static double getRateByMotorType(String motorType) { //tambah fitur 2
        return switch (motorType) {
            case "Yamaha NMAX" -> 120000;
            case "Honda Vario" -> 90000;
            case "Yamaha Aerox" -> 110000;
            case "Honda PCX" -> 125000;
            default -> 80000; // harga standar jika motor tidak terdaftar
        };
    }

    /**
     * Menghitung total biaya sewa.
     * Jika lama sewa lebih dari DISCOUNT_THRESHOLD,
     * maka diberikan diskon sebesar DISCOUNT_RATE.
     *
     * @return total biaya sewa setelah perhitungan diskon (jika ada)
     */
    public double calculateTotal() {
        double total = getRentalDays() * getDailyRate();

        if (getRentalDays() > DISCOUNT_THRESHOLD) {
            total = total - (total * DISCOUNT_RATE);
        }

        printInvoice(total);
        return total;
    }

    /**
     * Menampilkan informasi invoice ke layar.
     *
     * @param total total biaya yang harus dibayar penyewa
     */
    private void printInvoice(double total) {
        System.out.println("===== INVOICE RENTAL MOTOR =====");
        System.out.println("Nama Penyewa  : " + getCustomerName());
        System.out.println("Jenis Motor   : " + getMotorType());
        System.out.println("Lama Sewa     : " + getRentalDays() + " hari");
        System.out.println("Harga per Hari: Rp" + getDailyRate());
        System.out.println("Total Bayar   : Rp" + total);
        System.out.println("================================");
    }

    // Getter dan Setter

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMotorType() {
        return motorType;
    }

    public void setMotorType(String motorType) {
        this.motorType = motorType;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }
}
