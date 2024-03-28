import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *Authour: Hamza Khan 
 *Date; October 21, 2023
 *Description; Display the exact function and appearance as Lab 5 Document, however now the data is stored in an array 
 *             and can be redisplayed in the output box
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
 * 
 * 
 * 
 */
public class EagleEyeEnchance extends JFrame implements ActionListener{
	private JPanel inputPanel, outputPanel, controlPanel;
	private JTextField textInput;
	private JTextArea textOutput;
	private JLabel lblInstruction, lblInstructionTwo; // declare various GUI components
	private JButton btnAdd, btnDisplayArray, btnClear;
	private Picture pic;
	private TextPicture picBottom;
	private JScrollPane scroller;
	

	//Initialize variables for the new program with array limit 
	private String [] inputArray = new String [10];
	//set array runs to 0 
	private int arrayRuns = 0;

	//New method created to minimize the amount of lines of code 
	//in order to change the color of the eye and text 
	public static int color() {
		return (int)(255*Math.random());
	}


	public EagleEyeEnchance(){
		super("My Simple GUI"); //frame
		setLayout(new GridLayout(5,1)); // layout for my frame
		inputPanel = new JPanel(); // subpanels for different areas
		outputPanel = new JPanel();
		controlPanel = new JPanel();

		// create text components
		textInput = new JTextField("Hello There!!!", 20);
		lblInstruction = new JLabel (" This is a label only for output");
		lblInstructionTwo = new JLabel (" Your Name Displays Below");
		textOutput = new JTextArea (5,30);
		scroller = new JScrollPane(textOutput); //scroller for the text area
		btnAdd = new JButton("Add"); // create button to add to array and display 
		btnDisplayArray = new JButton("Display Array"); // Button to display the array
		btnClear = new JButton("Clear"); // Button to clear the array


		// create and set picture objects
		//set the postion of eye  
		pic = new Picture(100, 10, 150, 50);
		
		//create the new object called picBottom that displays the Texts
		picBottom = new TextPicture ("Hello World!", new Font("MonoSpaced", Font.PLAIN, 20)); 
		
		//set the original location of the text "You are Being Watched ;o)" 
		picBottom.setxPos(100);
		picBottom.setyPos(25);
		picBottom.repaint();


		// add components to panels
		inputPanel.add(lblInstruction);
		inputPanel.add(textInput);
		outputPanel.add(lblInstructionTwo);
		outputPanel.add(scroller);
		controlPanel.add(btnAdd); 

		//new buttons created being add
		controlPanel.add(btnDisplayArray);
		controlPanel.add(btnClear);


		// add components to the frame
		add(pic);
		add(inputPanel);
		add(outputPanel);
		add(controlPanel);
		add(picBottom);

		// add button as a listener in this frame for all 3 buttons
		btnAdd.addActionListener(this);
		btnDisplayArray.addActionListener(this);
		btnClear.addActionListener(this);



		// set size of frame
		setSize(350,400);
		setVisible(true);
		setLocation(100,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);




	}
	// method for actions events
	public void actionPerformed (ActionEvent e){
		if (e.getSource()==btnAdd){ // if btn is clicked
			if (arrayRuns < inputArray.length) { //if the array runs less then 10 then true 
				String input, output; //set strings 
				input = textInput.getText(); //get the input by using getText 
				output = textOutput.getText() + input + "\n"; // get output value by getting output text and adding input to it
				
				//set the text in the output box as the output string value/text 
				textOutput.setText(output);
				
				//set input array and array runs as input 
				//and overtime the statements runs the 
				//program will add 1 to arrayRuns to change the index 
				//Until index 10 reached 
				inputArray[arrayRuns] = input;
				arrayRuns++;

				//change colors using randomizer for RGB
				pic.setC(color(),color(),color());
				pic.repaint();
				picBottom.setC(color(), color(), color());
				picBottom.repaint();


			} else {
				//if the array is full then change "Hello World" to "Array is Full"
				// while also changing the font allowing the user to see it better
				picBottom.setTitleText("Array is Full");
				picBottom.setFont(new Font("Tahoma", Font.BOLD, 20)); // change font
				picBottom.repaint();
				textOutput.setText(""); //empty output box when array is full


			}

		}	else if (e.getSource() == btnDisplayArray) {
			String outputtedArray = ""; //init string 
			
			//for loop to run through all indexes and acquire the 
			//value or text at that index and skip line then finally 
			//allow the user to display back 
			for (int i = 0; i < arrayRuns; i++) { 
				outputtedArray += inputArray[i] + "\n";
			}
			textOutput.setText(outputtedArray);


		}

		else if (e.getSource() == btnClear) {
			//set all values to empty or zero, and set text back original 
			textInput.setText("");
			textOutput.setText("");
			arrayRuns = 0;
			picBottom.setTitleText("Hello World!");
			picBottom.setFont(new Font("MonoSpaced", Font.PLAIN, 20));		
			picBottom.repaint();
			
			
			//for loop to make all index values empty
			for (int i = 0; i < inputArray.length; i++) {
				inputArray[i] = null;
			}    



		}
	}
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

	}
}