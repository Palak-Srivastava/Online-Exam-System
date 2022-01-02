import java.awt.event.*;
import javax.swing.*;

public class exam_system extends JFrame implements ActionListener{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int[] m=new int[10];
	
	exam_system(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++) {
			jb[i]=new JRadioButton();
			add(jb[i]);
			bg.add(jb[i]);
			
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[0].setBounds(50,110,100,20);
		jb[0].setBounds(50,140,100,20);
		jb[0].setBounds(50,170,100,20);
		
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	
	

	void set() {
		jb[4].setSelected(true);
		if(current==0){
			l.setText("Q1: Which among these is not a primitive datatype");
			jb[0].setText("int");
			jb[1].setText("Float");
			jb[2].setText("boolean");	
			jb[3].setText("char");		
		}
		if(current==1){
			l.setText("Q2: Which class is avaiable to all the class automatically?");
			jb[0].setText("Swing");
			jb[1].setText("Applet");
			jb[2].setText("Object");	
			jb[3].setText("ActionEvent");
		}
		if(current==2){
			l.setText("Q3: Which package is directly avaiable to our class without importing it?");
			jb[0].setText("swing");
			jb[1].setText("applet");
			jb[2].setText("net");	
			jb[3].setText("lang");
		}
		if(current==3){
			l.setText("Q4: String class is defined in which package?");
			jb[0].setText("lang");
			jb[1].setText("swing");
			jb[2].setText("Applet");	
			jb[3].setText("awt");
		}
		if(current==4){
			l.setText("Q5: Which institute is best for java coaching?");
			jb[0].setText("Utech");
			jb[1].setText("Aptech");
			jb[2].setText("SSS IT");	
			jb[3].setText("jTech");
		}
		if(current==5){
			l.setText("Q6: Which one among these is not a keyword?");
			jb[0].setText("class");
			jb[1].setText("int");
			jb[2].setText("get");	
			jb[3].setText("if");
		}
		if(current==6){
			l.setText("Q7: Which one among these is not a class?");
			jb[0].setText("Swing");
			jb[1].setText("Actionperfomed");
			jb[2].setText("ActionEvent");	
			jb[3].setText("Button");
		}
		if(current==7){
			l.setText("Q8: Which amaong these is not a function of object class?");
			jb[0].setText("toString");
			jb[1].setText("finalize");
			jb[2].setText("equals");	
			jb[3].setText("getDocumentBase");
		}
		if(current==8){
			l.setText("Q9: Which function is not present in Applet class?");
			jb[0].setText("init");
			jb[1].setText("main");
			jb[2].setText("start");	
			jb[3].setText("destroy");
		}
		if(current==9){
			l.setText("Q10: Which one amaong these is not a valid component?");
			jb[0].setText("JButton");
			jb[1].setText("JList");
			jb[2].setText("JButtonGroup");	
			jb[3].setText("JTextArea");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1) 
		{
			if(check()) 
			{
				count+=1;
			}
			current++;
			set();
			if(current==9) 
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();
			if(current==9) {
				b2.setText("Result");
			}
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=0;i<x;i++,y++){
			if(e.getActionCommand().equals("Bookmark"+y)){
				if(check()){
					count++;
				}
				now=current;
				current=m[y];
				set();
				((JButton)e.getSource()).setEnabled(false);
				current=now;

			}
		}
		if(e.getActionCommand().equals("Result")){
			if(check()){
				count++;
			}

		current++;

		JOptionPane.showMessageDialog(this,"correct ans="+count);
		System.exit(0);
		}
		
	}



	boolean check() {
		if(current ==0)
			return(jb[1].isSelected());
		if(current ==1)
			return(jb[2].isSelected());
		if(current ==2)
			return(jb[3].isSelected());
		if(current ==3)
			return(jb[0].isSelected());
		if(current ==4)
			return(jb[2].isSelected());
		if(current ==5)
			return(jb[2].isSelected());
		if(current ==6)
			return(jb[1].isSelected());
		if(current ==7)
			return(jb[3].isSelected());
		if(current ==8)
			return(jb[1].isSelected());
		if(current ==8)
			return(jb[2].isSelected());
		return false;
	}

	public static void main(String[] args){
		new exam_system("Online Test of Java");
	}
}

