
import java.util.Scanner;

public class Account {
    private long soTK;
    private String tenTK;
    private double soTien;
    private String trangThai;
    
    public Account(long soTK, String tenTK, double soTien, String trangThai) {
        setSoTK(soTK);
        setTenTK(tenTK);
        setSoTien(soTien);
        setTrangThai(trangThai);
    }
    
    public long getSoTK() {
        return soTK;
    }

    public void setSoTK(long soTK) {
        if (soTK > 0 && soTK <= 999999) {
            this.soTK = soTK;
        } else {
            this.soTK = 999999;
            this.trangThai = "Số tài khoản không hợp lệ";
        }
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        if (tenTK == null || tenTK.trim().equals("")) {
            this.tenTK = "chua xac dinh";
            this.trangThai = "Ten tai khoan khong hop le. Ten tai khoan duoc khoi tao voi ten mac dinh";
        } else {
            this.tenTK = tenTK.trim();
        }
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        if (soTien < 50) {
            this.soTien = 50;
            this.trangThai = "So tien trong tai khoan khong hop le.Tai khoan duoc khoi tao voi so tien mac dinh";
        } else {
            this.soTien = soTien;
        }
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Account{" + "soTK=" + soTK + ", tenTK=" + tenTK + ", soTien=" + soTien + ", trangThai=" + trangThai + '}';
    }

    public void napTien(double soTien) {
        if (soTien <= 0) {
            this.trangThai += "So tien nap khong hop le. ";
        } else {
            this.soTien += soTien;
            this.trangThai = "Nap tien thanh cong. ";
        }
    }

    public void rutTien(double soTien) {
        if (soTien <= 0 || soTien > this.soTien) {
            this.trangThai += "So tien rut khong hop le. ";
        } else {
            this.soTien -= soTien;
            this.trangThai = "Rut tien thanh cong. ";
        }
    }
    
    
    public void chuyenKhoan(Account nguoiNhan, double soTien) {
    if (soTien <= 0 || soTien > this.soTien) {
        this.trangThai += "So tien chuyen khoan khong hop le. ";
    } else {
        this.soTien -= soTien;
        nguoiNhan.napTien(soTien);
        this.trangThai = "Chuyen khoan thanh cong. ";
    }
}

    public void daoHan(double INTEREST_RATE) {
        double interest = this.soTien * INTEREST_RATE;
        this.soTien += interest;
        this.trangThai = "Da dao han va lai suat la " + INTEREST_RATE + ". ";
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap so tai khoan: ");
        long soTK = scanner.nextLong();

        System.out.println("Nhap ten tai khoan: ");
        String tenTK = scanner.nextLine();

        System.out.println("Nhap so tien: ");
        double soTien = scanner.nextDouble();

        Account account = new Account(soTK, tenTK, soTien, "");

        System.out.println(account);

        System.out.print("nhap so tien can nap: ");
        double napTien = scanner.nextDouble();
        account.napTien(napTien);
        System.out.println(account);

        System.out.println("Nhap so tien can rut: ");
        double rutTien = scanner.nextDouble();
        account.rutTien(rutTien);
        System.out.println(account);

        System.out.println("Nhap so tai khoan nguoi nhan: ");
        long soTKNguoiNhan = scanner.nextLong();
        System.out.println("Nhap so tien can chuyen khoan: ");
        double chuyenKhoan = scanner.nextDouble();

        Account nguoiNhan = new Account(soTKNguoiNhan, "", 0, "");
        account.chuyenKhoan(nguoiNhan, chuyenKhoan);

        System.out.println(account);
        System.out.println(nguoiNhan);
    }

    
 }

 
