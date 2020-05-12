import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
public class InterfaceLwz extends JFrame implements ActionListener,FocusListener{
	private JPanel pan1, pan2;
	private JTextField compressed, decompressed, champt1, champt2;
	private JButton buttonCompressed, buttonDecompresser;
	private FlowLayout fl;
	public String secour;
	public String test;
	public InterfaceLwz(){
		setTitle("Interface LWZ");
		setSize(450,500);
		secour = new String();
		Container contenue = getContentPane();
		fl = new FlowLayout();
		fl.setHgap(15);
		fl.setVgap(30);
		pan1 = new JPanel();
		pan1.setLayout(fl);
		buttonCompressed = new JButton("Compresser");
		buttonCompressed.addActionListener(this);
		compressed = new JTextField("Entre le text a compresser",30);
		compressed.addActionListener(this);
		compressed.addFocusListener(this);
		champt1 = new JTextField(30);
		champt1.setEditable(false);
		champt1.addActionListener(this);
		pan1.add(champt1);
		pan1.add(compressed);
		pan1.add(buttonCompressed);
		buttonDecompresser = new JButton("Decompresser");
		buttonDecompresser.addActionListener(this);
		decompressed = new JTextField(30);
		decompressed.addActionListener(this);
		decompressed.addFocusListener(this);
		champt2 = new JTextField(30);
		champt2.setEditable(false);
		pan1.add(champt2);
		pan1.add(decompressed);
		pan1.add(buttonDecompresser);
		contenue.add(pan1,"Center");
	}
	public void actionPerformed(ActionEvent e){
		JButton source = (JButton)e.getSource();
		CodeLwz code = new CodeLwz();
		//String decomp = "";
		if( source == buttonCompressed ){
			String ch = compressed.getText();
			String comp = code.compresser(ch);
			this.test = comp;
			secour = code.decompresser(comp);
			char[] tabChar = comp.toCharArray();
			String chaine = "";
			for (int i = 0; i < tabChar.length; i++) {
				chaine =chaine + (int) tabChar[i]+" ";
			}
			champt1.setText(chaine);
		}
		String ch1 = decompressed.getText();
		if(source == buttonDecompresser && !ch1.equals("")){
			champt2.setText(secour);
		}
	}
	public void focusLost(FocusEvent e){
		JTextField source = (JTextField)e.getSource();
		if(source == compressed) System.out.println("Fin compression");
		if(source == decompressed) System.out.println("fin codage");
	}
	public void focusGained(FocusEvent e) {
		CodeLwz code = new CodeLwz();
		JTextField source = (JTextField)e.getSource();
		if(source == compressed) System.out.println("L'utilisateur ecrit...?");
		if(source == decompressed){
			char[] tabChar = this.test.toCharArray();
			String chaine1 = "";
			for (char c : tabChar) {
				chaine1 =chaine1+(int)c;
			}
			decompressed.setText(chaine1);
		}
	}
	
}