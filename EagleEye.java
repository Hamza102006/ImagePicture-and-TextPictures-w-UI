import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *Authour: Hamza Khan 
 *Date; October 21, 2023
 *Description; Display the exact function and appearance as Lab 5 Document  
 *
 * 
 * METHODS:
 *
 *  public class EagleEye extends JFrame implements ActionListener{ //class which extends jFrame and run actionlistner
 *
 *	public static int color() { //method to randomize colors values for RGB
 *
 *	public EagleEye(){ //method which performs everything which happens in GUI
 *
 *	public void actionPerformed (ActionEvent e){ //method which reacts when a button is clicked 
 *
 *	public static void main(String[] args) { //call the GUI to be ran 

 *
 */
public class EagleEye extends JFrame implements ActionListener{
	private JPanel inputPanel, outputPanel, controlPanel;
	private JTextField textInput;
	private JTextArea textOutput;
	private JLabel lblInstruction, lblInstructionTwo; // declare various GUI components
	private JButton btnAdd;
	private Picture pic;
	private TextPicture picBottom;
	private JScrollPane scroller; 
	
	
	
	//New method created to minimize the amount of lines of code 
	//in order to change the color of the eye and text 
	public static int color() {
		return (int)(255*Math.random());
	}


	public EagleEye(){
		super("My Simple GUI"); // title for the frame
		setLayout(new GridLayout(5,1)); // layout for my frame
		inputPanel = new JPanel(); // subpanels for different areas
		outputPanel = new JPanel();
		controlPanel = new JPanel();

		// create text components
		textInput = new JTextField("Mr.Campos is the Coolest!", 20);
		lblInstruction = new JLabel (" Enter Your First Name, Last Name Below");
		lblInstructionTwo = new JLabel (" Your Name Displays Below"); //New label created to fit requirements
		textOutput = new JTextArea (5,30);
		scroller = new JScrollPane(textOutput); //scroller for the text area
		btnAdd = new JButton("Do something"); // create button


		// create and set picture objects
		//set postion for the eye 
		pic = new Picture(100, 10, 150, 50);

		//create the new object called picBottom that displays the Texts
		picBottom = new TextPicture ("You are Being Watched ;o)", new Font("MonoSpaced", Font.PLAIN, 20));

		//set the original location of the text "You are Being Watched ;o)" 
		picBottom.setxPos(100);
		picBottom.setyPos(25);
		picBottom.repaint();

		// add components to panels
		inputPanel.add(lblInstruction);
		inputPanel.add(textInput);
		outputPanel.add(lblInstructionTwo); //add the second label in order to fit requirement and grid layout order
		outputPanel.add(scroller);
		controlPanel.add(btnAdd);

		// add components to the frame
		add(pic);
		add(inputPanel);
		add(outputPanel);
		add(controlPanel);
		add(picBottom); //new add picBottom which is now the text  

		// add button as a listener in this frame
		btnAdd.addActionListener(this);

		// set size of frame
		setSize(350,400);
		setVisible(true);
		setLocation(100,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	// method for actions events
	public void actionPerformed (ActionEvent e){
		if (e.getSource()==btnAdd){ // if btn is clicked
			String input, output; //create strings 

			input = textInput.getText();  //get the input by using getText 
			output = textOutput.getText() + input + "\n"; // get output value by getting output text and adding input to it 

			//set the text in the output box as the output string value/text 
			textOutput.setText(output);

			//randomized colour values for all r,g,b
			//set colour for RGB as random value generators for both the eye and text 
			pic.setC(color(), color(), color());
			pic.repaint();
			picBottom.setC(color(), color(), color());
			picBottom.repaint();

		}
	}
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		EagleEye sGUI = new EagleEye(); //run teh GUI
	}
}