package HDC;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class Main {
	public static void Housedata ( List<String> HL, int i ) {
		File file1 = new File ( ".\\recycle\\housedata\\" + HL.get(i) + "_data.txt" ); //書き込むファイル名
		PrintWriter pw;
		try {
			pw = new PrintWriter ( new BufferedWriter ( new FileWriter ( file1, true ) ) );
			pw.println ( "Name " + HL.get(i) );
			pw.println ("Coin 8000000");
			pw.close();
			System.out.println ( "追加しました" );
		} catch ( IOException e ) {
			System.err.println ( "File cannot be Writed." );
		} //printlnの用意
	}
	public static void Furnituredata ( freezer kekka, List <String> HL, int i ) {
		File file = new File ( ".\\recycle\\furnituredata\\" + HL.get(i) + "_furniture.txt" ); //書き込むファイル名
		PrintWriter pw;
		try {
			pw = new PrintWriter ( new BufferedWriter ( new FileWriter ( file, true ) ) );
			pw.println ( "Name 冷蔵庫" );
			pw.println ( "Value " + kekka.getCost() );
			pw.println ( "Spec " + kekka.getSpec() );
			pw.println ("Minus 4");
			pw.close();
			System.out.println ( "追加しました" );
		} catch ( IOException e ) {
			System.err.println ( "File cannot be Writed." );
		} //printlnの用意
	}
	public static void WishList ( freezer kekka, List <String> HL, int i, StringBuilder sstr ) {
		File file = new File ( ".\\recycle\\wishlist\\" + HL.get(i) + "_wishlist.txt" ); //書き込むファイル名
		PrintWriter pw;
		int shinnko = kekka.getCost();
		int tyuuuko = kekka.getCost();
		int Junk = kekka.getCost();
		if ( sstr.equals("貧乏") ) {
			shinnko = ( int )( kekka.getCost() * 0.6 );
			tyuuuko = ( int )( kekka.getCost() * 0.3);
			Junk = ( int )( kekka.getCost() * 0.05 );
		}
		else if ( sstr.equals( "金持ち" ) ) {
			shinnko = ( int )( kekka.getCost() * 0.7 );
			tyuuuko = ( int )( kekka.getCost() * 0.4 );
			Junk = ( int )( kekka.getCost() * 0.1 );
		}
		
		try {
			pw = new PrintWriter ( new BufferedWriter ( new FileWriter ( file, true ) ) );
			pw.println ( "Name 冷蔵庫" );
			pw.println ( "Durability 90" );
			pw.println ( "Value " + shinnko );
			pw.println ( "Spec " + kekka.getSpec() );
			
			pw.println ( "Name 冷蔵庫" );
			pw.println ( "Durability 60" );
			pw.println ( "Value " + tyuuuko );
			pw.println ( "Spec " + kekka.getSpec() );
			
			pw.println ( "Name 冷蔵庫" );
			pw.println ( "Durability 10" );
			pw.println ( "Value " + Junk );
			pw.println ( "Spec " + kekka.getSpec() );
			pw.close();
			System.out.println ( "追加しました" );
		} catch ( IOException e ) {
			System.err.println ( "File cannot be Writed." );
		} //printlnの用意
	}

	public static void main(String[] args) {
		ReadFile RF = new ReadFile();
		RF.createNewFreezerList(".\\freezer\\Newdata.txt");
		Findfreezer FR = new Findfreezer();
		RF.createHouseList(".\\freezer\\Houselist2.txt");
		List <String> HL = RF.getHouselist();		
		for ( int i=0; i < HL.size(); i++ ) {
			int ninzuu = FR.personselector();
			FR.findfreezerspec( FR.personcountspec ( ninzuu ), RF );
			StringBuilder sstr = new StringBuilder();
			freezer kekka = FR.findfreezercost ( sstr );
			Furnituredata ( kekka, HL, i );
			Housedata ( HL, i );
			WishList ( kekka, HL, i, sstr );
			
		}
	}

}
