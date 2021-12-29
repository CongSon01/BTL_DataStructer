import java.io.*;
import java.util.Scanner;

public class DuLichNhanhCan {
    private static int SoDiem = 4;
    private static int [] DuongDi = new int[SoDiem + 1];
    private static int []DuongDiTotNhat = new int[SoDiem + 1];
    private static boolean [] ChuaDiQua = new boolean[SoDiem + 1];
    private static int ChiPhiTotNhat = Integer.MAX_VALUE;
    private static int [][] ChiPhi  = new int[SoDiem][SoDiem];

    public static void NhanhCanTSP(int ChiPhiHienTai, int index) {
        for (int i = 0 ; i < SoDiem ; i++ ) /*i = 0 -> Số thành phố - 1*/ 
            if ( ChuaDiQua[i] && ChiPhi[DuongDi[index-1]][i] > 0  ) /*Chưa đi qua thành phố này && Có đường đi tới*/
            {
                if ( i == DuongDi[0] && index < SoDiem ) /*i == Chỉ số thành phố khởi hành && Chỉ số thành phố hiện tại < Số thành phố*/
                    continue;
                
                // System.out.println("index : "+index);
                // System.out.println("Chi phi hien tai truoc : " + ChiPhiHienTai);
    
                DuongDi[index] = i; /*Đi qua;*/
                // ChiPhiHienTai + ChiPhi[DuongDi[index-1]][i] /*Tính chi phí hiện tại;*/
    
                // for (int j = 0 ; j <= index ; j++)
                    // System.out.print(DuongDi[j]+" ");
                // System.out.println();
                // System.out.println("Tu "+DuongDi[index-1]+" den "+i+" mat "+ChiPhi[DuongDi[index-1]][i]);
                // System.out.println("Chi phi hien tai sau :  "+ (ChiPhiHienTai + ChiPhi[DuongDi[index-1]][i]));
    
                if ( ChiPhiHienTai + ChiPhi[DuongDi[index-1]][i] < ChiPhiTotNhat ) /*Chi phí hiện tại < Chi phí tốt nhất*/ 
                {
                    if ( index == SoDiem ) /*Chỉ số thành phố hiện tại == Số thành phố*/
                    {
                        ChiPhiTotNhat = ChiPhiHienTai + ChiPhi[DuongDi[index-1]][i];/*Thay đổi chi phí tốt nhất;*/
                        for (int j = 0 ; j <= SoDiem ; j++)
                            DuongDiTotNhat[j] = DuongDi[j];
                        // System.out.println("----------Thay doi chi phi tot nhat---------------");
                    }
                    else
                    {
                        ChuaDiQua[i] = false; /*Đánh dấu đã đi qua thành phố này;*/
                        /*NhanhCanTSP(Chi phí tốt nhất , Chi phí hiện tại , Chỉ số thành phố tiếp theo);*/
                        NhanhCanTSP(ChiPhiHienTai + ChiPhi[DuongDi[index-1]][i], index + 1);
                        ChuaDiQua[i] = true; /*Bỏ đánh dấy đã đi qua thành phố này;*/
                    }
                }
            }
    }

    
    public static void main(String[] args) throws IOException {

        // Get matrix //
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ten file");
        String file = input.nextLine();
        
        ChiPhi = new int[SoDiem][SoDiem];
        FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);

        // Doc du lieu tu file ra ma tran
        for (int row = 0 ; row < SoDiem ; row++) {

            String line = b.readLine();
            String[] values = line.trim().split("\\s+");

            for (int col = 0; col < SoDiem; col++) {
                ChiPhi[row][col] = Integer.parseInt(values[col]);
            }
        }

        // Hien thi matrix doc duoc
        for (int i = 0; i < ChiPhi.length; i++) {
            for (int j = 0; j < ChiPhi.length; j++) {
                System.out.print(ChiPhi[i][j] + "  ");
            }
            System.out.println();
        }

        // Closing file
        b.close();
        

        // Khởi tạo bài toán
        for(int i = 0 ; i < SoDiem ; i++) {
            ChuaDiQua[i] = true;
        }
        
        System.out.println("Nhập điểm bắt đầu đi: ");
        DuongDi[0] = input.nextInt();
        while (DuongDi[0] > SoDiem) {
            System.out.println(DuongDi[0] + " không có trong đồ thị");
            System.out.println("Nhập điểm bắt đầu đi: ");
            DuongDi[0] = input.nextInt();
        }
        
        
        NhanhCanTSP(0, 1);

        System.out.println("Duong di voi chi phi thap nhat la: ");
        for (int i = 0; i <= SoDiem; i++) {
            System.out.print(DuongDiTotNhat[i] + "  ");
        }
        System.out.println();
        System.out.println("Ton chi: " + ChiPhiTotNhat + " chi phi");
    }
}
