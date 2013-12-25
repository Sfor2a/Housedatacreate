package HDC;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class Main {

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
			File file = new File ( ".\\recycle\\furnituredata\\" + HL.get(i) + "_furniture.txt" ); //�������ރt�@�C����
			PrintWriter pw;
			try {
				pw = new PrintWriter ( new BufferedWriter ( new FileWriter ( file, true ) ) );
				pw.println ( "Name �①��" );
				pw.println ( "Value " + kekka.getCost() );
				pw.println ( "Spec " + kekka.getSpec() );
				pw.println ("Minus 4");
				pw.close();
				System.out.println ( "�ǉ����܂���" );
			} catch ( IOException e ) {
				System.err.println ( "File cannot be Writed." );
			} //println�̗p��
			
			File file1 = new File ( ".\\recycle\\housedata\\" + HL.get(i) + "_data.txt" ); //�������ރt�@�C����
			try {
				pw = new PrintWriter ( new BufferedWriter ( new FileWriter ( file1, true ) ) );
				pw.println ( "Name " + HL.get(i) );
				pw.println ("Coin 8000000");
				pw.close();
				System.out.println ( "�ǉ����܂���" );
			} catch ( IOException e ) {
				System.err.println ( "File cannot be Writed." );
			} //println�̗p��
		}
		
	}

}
