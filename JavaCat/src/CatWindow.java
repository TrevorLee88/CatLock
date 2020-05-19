import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class CatWindow {
static Boolean cat=false;
static int shift = 0;
static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
static int screenHeight = screenSize.height;
static int screenWidth = screenSize.width;
static int pX = 0;
static int pY = 0;
	public static void main(String[] args) {
		//button window
		JFrame f=new JFrame();//creating instance of JFrame  
		f.setTitle("Cat Locker");
		JLabel j = new JLabel("X");
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 200, 200);
		label.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                // Get x,y and store them
                pX = me.getX();
                pY = me.getY();
            }
             public void mouseDragged(MouseEvent me) {
                f.setLocation(f.getLocation().x + me.getX() - pX,
                        f.getLocation().y + me.getY() - pY);
            }
        });
		label.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent me) {

                f.setLocation(f.getLocation().x + me.getX() - pX,
                        f.getLocation().y + me.getY() - pY);
            }
        });
		f.setUndecorated(true);
		f.setOpacity(0.7F);
		f.setShape(new RoundRectangle2D.Double(0, 0, 100, 100, 70, 100));//xy xy size size
		URL url = CatWindow.class.getResource("paw.png");
		ImageIcon icon = new ImageIcon(url);
		JLabel b = new JLabel(icon);
		b.setOpaque(true);
		b.setSize(100,100);
		f.setSize(100,100);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  
		f.setAlwaysOnTop(true);
		j.setBounds(45, 0, 20, 20);
		j.setFont(j.getFont().deriveFont(20f));
		f.add(j);
		f.add(label);
		f.add(b);//adding button in JFrame    
		j.addMouseListener(new MouseAdapter()   {   
	        public void mouseClicked(MouseEvent e)   
	        {   
	        	System.exit(0); //X close
	        }   
		});
		f.addWindowListener(new WindowAdapter() {//terminate program when window closes
	            @Override
	            public void windowClosing(WindowEvent e) {
	               System.exit(0);  
	            }
	        });
		//hidden window
		JFrame f2=new JFrame();
		f2.setSize(0,0);//
		f2.setUndecorated(true);
		f2.setOpacity(0.2F);
		f2.setLayout(null);//  
		f2.setVisible(false);//  
		f2.setAlwaysOnTop(false);
		f2.setResizable(false);
		f2.setForeground(Color.BLACK);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//F2 background
		JLabel j2 = new JLabel("");
		j2.setSize(screenWidth,screenHeight);
		j2.setBackground(Color.RED);
		j2.setOpaque(true);
		f2.add(j2);
		//button event
		label.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
		    	if(cat==false) {
		        //is a cat
		    	System.out.println("cat");
		        cat=true;
		        freeze();
		    	}
		    	else
		    	{
		    		System.out.println("no cat");
			        cat=false;
			        unfreeze();
		    	}
		    }
		    //cat funtions
			private void unfreeze() {
				//f2.dispose();close window
				//hide window
				f2.setSize(0,0);//  
				f2.setLayout(null);//  
				f2.setVisible(false);//  
				f2.setAlwaysOnTop(false);
				f2.toBack();
				f.toFront();
			}
			private void freeze() { 
				j2.setSize(screenWidth,screenHeight);
				f2.setSize(screenWidth,screenHeight);//  
				f2.setLayout(null);//  
				f2.setVisible(true);//
				f2.setAlwaysOnTop(false);
				f2.toFront();
				f.toFront();
			}
		});
		//shift+backspacer
				KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
					public boolean dispatchKeyEvent(KeyEvent e) {
						if(e.getKeyCode()==KeyEvent.VK_CAPS_LOCK) {
				        	System.out.println("Caps LOCKed");
				        	shift++;
				        	egg();
				        	return false;
				        }
				        else
				        {
				        	System.out.println("No Changy Wangy");
				        	shift=0;
					        return false;
				        }
				      }

					private void egg() {
						//Keypress Check
						if (shift == 30)
						{
						shift = 0;
						if(cat==false) {
						        //is a cat
						    	System.out.println("cat 2");
						        cat=true;
						        j2.setSize(screenWidth,screenHeight);
								f2.setSize(screenWidth,screenHeight);//  
								f2.setLayout(null);//  
								f2.setVisible(true);//
								f2.setAlwaysOnTop(false);
								f2.toFront();
								f.toFront();
						    	}
						    	else
						    	{
						    		System.out.println("no cat 2");
							        cat=false;
							        f2.setSize(0,0);//  
									f2.setLayout(null);//  
									f2.setVisible(false);//  
									f2.setAlwaysOnTop(false);
									f2.toBack();
									f.toFront();
						    	}}
					}
					
				});
				
	}
	
}
