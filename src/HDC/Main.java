package HDC;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

	public static void main(String[] args) {
		ReadFile RF = new ReadFile();
		RF.createNewFreezerList(".\\freezer\\Newdata.txt");
		Findfreezer FR = new Findfreezer();
		for ( int i=0; i<41; i++ ) {
			int ninzuu = FR.personselector();
			FR.findfreezerspec( FR.personcountspec ( ninzuu ), RF );
			StringBuilder sstr = new StringBuilder();
			freezer kekka = FR.findfreezercost ( sstr );
			File file = new File ( ".\\freezer\\kakikomi.txt" ); //�������ރt�@�C����
			PrintWriter pw;
			try {
				pw = new PrintWriter ( new BufferedWriter ( new FileWriter ( file, true ) ) );
				pw.println ( "�l���F"+ ninzuu + " �l�i�F" + kekka.getCost() + " �e��:" + kekka.getSpec() + sstr );
				pw.close();
				System.out.println ( "�ǉ����܂���" );
			} catch ( IOException e ) {
				System.err.println ( "File cannot be Writed." );
			} //println�̗p��
		}
		
	}

}
