package buoi2_bai3;

import java.util.Scanner;

public class PhanSo {
	int tu;
	int mau;
	public PhanSo() {
	}
//======================================================================//
	public PhanSo(int tu, int mau) {
		this.tu=tu;
		this.mau=mau;
	}
//======================================================================//
	public void nhapPhanSo() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap tu:");
		this.tu = scanner.nextInt();
		System.out.print("Nhap mau:");
		this.mau = scanner.nextInt();
		while(this.mau==0) {
			System.out.print("Nhap lai mau:");
			this.mau = scanner.nextInt();
		}
		//scanner.close();
	}
//======================================================================//
	public void inPhanSo() {
		PhanSo ps = new PhanSo(this.tu,this.mau);
		ps=ps.toiGian();
		if (ps.mau==0) System.out.println("Khong ton tai");
		else if(ps.tu==0) System.out.println(ps.tu);
		else if(ps.mau==1) System.out.println(ps.tu);
		else if(ps.mau==-1) System.out.println(-ps.tu);
		else if(ps.mau<0) System.out.println(-ps.tu+"/"+ps.mau);
		else System.out.println(ps.tu+"/"+ps.mau);
	}
//======================================================================//
	public PhanSo giaTriNghichDao() {
		int tu = this.tu;
		int mau= this.mau;
		int temp =tu;
		tu=mau;
		mau=temp;
		PhanSo newPhanSo = new PhanSo(tu,mau);
		return newPhanSo;
	}
//======================================================================//
	public void nghichDao() {
		int temp=this.tu;
		this.tu=this.mau;
		this.mau=temp;
	}
//======================================================================//
	public double giaTriThuc() {
		double t = (double) this.tu/this.mau;
		return t;
	}
//======================================================================//
	public boolean lonHon(PhanSo a) {
		if(this.tu/this.mau>a.tu/a.mau)	return true;
		else return false;
	}
//======================================================================//
	public int bcnn(int a, int b) {
		int max = Math.max(a, b);
		int maxvalue=a*b;
		for(int i=max; i<=maxvalue; i++) {
			if(i%a==0 && i%b==0) {
				return i; 
			}
		}
		return maxvalue;
	}
//======================================================================//
	public int ucln(int a, int b) {
		if (a==0) return b;
		else if(b==0) return a;
		else if(a==0 || b==0) return 0;
		
		while (a!=b){
			if (a>b){
	            a-=b;
	        }else{
	            b-=a;
	        }
	    }
	    return a;
	}
//======================================================================//
	public PhanSo cong(PhanSo a) {
		int mauChung=bcnn(this.mau,a.mau);
		int mau=mauChung;
		int tu=(this.tu*(mauChung/this.mau))+ (a.tu*(mauChung/a.mau));
		
		PhanSo newPhanSo = new PhanSo(tu,mau);
		return newPhanSo;
	}
//======================================================================//
	public PhanSo tru(PhanSo a) {
		int mauChung=bcnn(this.mau,a.mau);
		int mau=mauChung;
		int tu=(this.tu*(mauChung/this.mau))-(a.tu*(mauChung/a.mau));

		PhanSo newPhanSo = new PhanSo(tu,mau);
		return newPhanSo;
	}
//======================================================================//
	public PhanSo nhan(PhanSo a) {
		int mau=this.mau*a.mau;
		int tu=this.tu*a.tu;
		PhanSo newPhanSo = new PhanSo(tu,mau);
		return newPhanSo;
	}
//======================================================================//
	public PhanSo chia(PhanSo a) {
		int mau=this.mau*a.tu;
		int tu=this.tu*a.mau;
		
		PhanSo newPhanSo = new PhanSo(tu,mau);
		return newPhanSo;
	}
//======================================================================//
	public PhanSo toiGian() {
		PhanSo ps= new PhanSo(this.tu,this.mau);
		tu = ps.tu;
		mau= ps.mau;
		int ucln= ps.ucln(tu, mau);
		if(ucln>1) {
			ps.tu/=ucln;
			ps.mau/=ucln;
		}
		return ps;
	}
}
