package hellotvxlet;

import org.dvb.ui.*;
import java.awt.event.*;
import javax.tv.xlet.*;
import org.havi.ui.event.*;
import org.havi.ui.*;
import org.davic.resources.*;

public class HelloTVXlet implements Xlet, HActionListener, ResourceClient
{ 
    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug=true;
    
    private HTextButton btnAnswerA;
    private HTextButton btnAnswerB;
    private HTextButton btnAnswerC;
    private HTextButton btnAnswerD;
    private HTextButton btnClose;
    private HTextButton btnStart;
    
    private HStaticText lblQuestion;
    private HStaticText lblPoints;
    private HStaticText lblIntro;
    private HStaticText lblTotalPoints;

    private int intPoints = 0;
    private int i = -1; //First right = i++ 
    
   private String[][] arrayQuestion = { 
        {"How many planets does the solar system count?", "8", "9","7","6","Right","Wrong","Wrong","Wrong"},
        {"Wich planet is the hottest?", "Earth", "Mercury","Venus","Jupiter","Wrong","Wrong","Right","Wrong"},
        {"Wich planet is the biggest?", "Mars", "Saturn","Uranus","Jupiter","Wrong","Wrong","Wrong","Right"},
        {"Wich planet is the farest from the sun?", "Jupiter", "Earth","Pluto","Saturn","Wrong","Wrong","Right","Wrong"},
        {"Wich is the brightest object in the sky?", "Venus", "Mars","Mercury","Pluto","Right","Wrong","Wrong","Wrong"},
        {"Who was the first astronaut to walk on the moon?", "Buzz Aldrin", "Andrei Borisenko","Dirk Frimout","Neill Armstrong","Wrong","Wrong","Wrong","Right"},
        {"What country had the first space station?", "America", "Russia","China","Europe","Wrong","Right","Wrong","Wrong"},
        {"Which was the first planet seen by a telescope?", "Mars", "Uranus","Mercury","Jupiter","Wrong","Right","Wrong","Wrong"},
    };
    public void notifyRelease (ResourceProxy proxy)
    { 
    
    }
    
    public void release (ResourceProxy proxy)
    {
    
    }
    
    public boolean requestRelease (ResourceProxy proxy , Object requestData) 
    {
        return false; 
    }
    

    public void initXlet(XletContext context) throws XletStateChangeException
    {
      this.actueleXletContext = context;
      HSceneTemplate sceneTemplate = new HSceneTemplate();      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
    
      /**
       *  INTRO SCHERM
       * 
      */
      lblIntro = new HStaticText("It's QuizTime!");
      lblIntro.setLocation(0,200);
      lblIntro.setSize(700,50);
      lblIntro.setBackground(new DVBColor(0, 0, 0, 179)); 

      btnStart = new HTextButton("Start");
      btnStart.setLocation(245,400);
      btnStart.setSize(200,50);
      btnStart.setBackground(new DVBColor(0, 0, 0, 179));
      btnStart.setBackgroundMode(HVisible.BACKGROUND_FILL);
 
      /**
       *  QUESTION SCHERM
       * 
      */
      lblQuestion = new HStaticText();
      lblQuestion.setLocation(100, 40);
      lblQuestion.setSize(500,50);
      lblQuestion.setBackground(new DVBColor(0, 0, 0, 179));
      lblQuestion.setVisible(false);
      
      btnAnswerA = new HTextButton();
      btnAnswerA.setLocation(245,150);
      btnAnswerA.setSize(250,50);
      btnAnswerA.setBackground(new DVBColor(0, 0, 0, 179));
      btnAnswerA.setBackgroundMode(HVisible.BACKGROUND_FILL);
      btnAnswerA.setVisible(false);

      btnAnswerB = new HTextButton();
      btnAnswerB.setLocation(245,220);
      btnAnswerB.setSize(250,50);
      btnAnswerB.setBackground(new DVBColor(0, 0, 0, 179));
      btnAnswerB.setBackgroundMode(HVisible.BACKGROUND_FILL);
      btnAnswerB.setVisible(false);
            
      btnAnswerC = new HTextButton();
      btnAnswerC.setLocation(245,290);
      btnAnswerC.setSize(250,50);
      btnAnswerC.setBackground(new DVBColor(0, 0, 0, 179));
      btnAnswerC.setBackgroundMode(HVisible.BACKGROUND_FILL);
      btnAnswerC.setVisible(false);
      
      btnAnswerD = new HTextButton();
      btnAnswerD.setLocation(245,360);
      btnAnswerD.setSize(250,50);
      btnAnswerD.setBackground(new DVBColor(0, 0, 0, 179));
      btnAnswerD.setBackgroundMode(HVisible.BACKGROUND_FILL);
      btnAnswerD.setVisible(false);
      
      btnClose = new HTextButton("Close");
      btnClose.setLocation(10,480);
      btnClose.setSize(200,50);
      btnClose.setBackground(new DVBColor(0, 0, 0, 179));
      btnClose.setBackgroundMode(HVisible.BACKGROUND_FILL);
      btnClose.setVisible(false);

      /**
       *  FOCUS CHANGE
       * 
      */
      btnAnswerA.setFocusTraversal(btnClose, btnAnswerB, btnClose, btnAnswerB);
      btnAnswerB.setFocusTraversal(btnAnswerA, btnAnswerC, btnAnswerA, btnAnswerC);
      btnAnswerC.setFocusTraversal(btnAnswerB, btnAnswerD, btnAnswerB, btnAnswerD);
      btnAnswerD.setFocusTraversal(btnAnswerC, btnClose, btnAnswerC, btnClose);
      btnClose.setFocusTraversal(btnAnswerD, btnAnswerA, btnAnswerD, btnAnswerA);
      
      /**
       *  POINTS LABELS
       * 
      */      
      lblPoints = new HStaticText(Integer.toString(intPoints));
      lblPoints.setLocation(600, 480);
      lblPoints.setSize(50,50);
      lblPoints.setVisible(false);
        
      lblTotalPoints = new HStaticText("Score:");
      lblTotalPoints.setLocation(0,150);
      lblTotalPoints.setSize(700,50);
      lblTotalPoints.setBackground(new DVBColor(0, 0, 0, 179));
      lblTotalPoints.setVisible(false);
      
      /**
       *  SCENE BUILD
       * 
      */      
      scene.add(lblQuestion);
      scene.add(btnAnswerA);
      scene.add(btnAnswerC);
      scene.add(btnAnswerB);
      scene.add(btnAnswerD);
      scene.add(btnClose);
      scene.add(btnStart);
      scene.add(lblPoints);
      scene.add(lblIntro);
      scene.add(lblTotalPoints);
      
      
      /**
       *  BACKGROUND TRANSPARANT ( SO YOU CAN SEE THE SPACE IMAGE)
       * 
      */      
      scene.setBackground( new DVBColor(0, 0, 0, 200) );
      scene.setBackgroundMode( HVisible.BACKGROUND_FILL );
      btnStart.requestFocus();
      
      /**
       *  LISENERS
       * 
      */      
      btnStart.setActionCommand("Right");
      btnClose.setActionCommand("stop");
      btnAnswerA.addHActionListener(this);
      btnAnswerC.addHActionListener(this);
      btnAnswerB.addHActionListener(this);
      btnAnswerD.addHActionListener(this);
      btnClose.addHActionListener(this);
      btnStart.addHActionListener(this);
    }

    public void startXlet() 
    {
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() 
    {
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException
    {
    }
    public void endGame(){
           scene.setBackground( new DVBColor(0, 0, 0, 200) );
           scene.setBackgroundMode( HVisible.BACKGROUND_FILL ); 
           btnAnswerA.setVisible(false);
           btnAnswerB.setVisible(false);
           btnAnswerC.setVisible(false);
           btnAnswerD.setVisible(true);
           btnClose.setVisible(false);
           lblQuestion.setVisible(false);
           lblTotalPoints.setVisible(true);
           lblPoints.setLocation(320,230);
           intPoints = -1;
           i = 0;
           btnAnswerD.setTextContent("Retry", HState.NORMAL_STATE);
           btnAnswerD.setActionCommand("Right");
     }
    public void createQuestion(int i){
            
            btnStart.setVisible(false);
            lblIntro.setVisible(false);
            btnAnswerA.setVisible(true);
            btnAnswerB.setVisible(true);
            btnAnswerC.setVisible(true);
            btnAnswerD.setVisible(true);
            btnClose.setVisible(true);
            lblPoints.setVisible(true);
            lblQuestion.setVisible(true);
            scene.setVisible(true);
            lblPoints.setLocation(600, 480);
            lblTotalPoints.setVisible(false);

            btnAnswerA.requestFocus();
                    
            lblQuestion.setTextContent(arrayQuestion[i][0], HState.NORMAL_STATE);
            btnAnswerA.setTextContent(arrayQuestion[i][1], HState.NORMAL_STATE);
            btnAnswerB.setTextContent(arrayQuestion[i][2], HState.NORMAL_STATE);
            btnAnswerC.setTextContent(arrayQuestion[i][3], HState.NORMAL_STATE);
            btnAnswerD.setTextContent(arrayQuestion[i][4], HState.NORMAL_STATE);
                   
            btnAnswerA.setActionCommand(arrayQuestion[i][5]);
            btnAnswerB.setActionCommand(arrayQuestion[i][6]);
            btnAnswerC.setActionCommand(arrayQuestion[i][7]);
            btnAnswerD.setActionCommand(arrayQuestion[i][8]);
    }
    public void actionPerformed(ActionEvent e)
    {
      /**
       *  CONTROL OF ACTION
       * 
      */      
        if(e.getActionCommand().equals("Right"))
        {
            lblQuestion.setVisible(true);
            btnAnswerA.setVisible(true);
            btnAnswerB.setVisible(true);
            btnAnswerC.setVisible(true);
            btnAnswerD.setVisible(true);
            lblPoints.setLocation(600, 480);
            lblTotalPoints.setVisible(false);
            btnClose.setVisible(true);
            scene.setBackground( new DVBColor(0, 0, 0, 200) );
            scene.setBackgroundMode( HVisible.BACKGROUND_FILL );
            btnAnswerA.requestFocus();
            intPoints++;
            lblPoints.setTextContent(Integer.toString(intPoints), HState.NORMAL_STATE);
            System.out.println(intPoints);
            i++;
            
            if(i == 8){                  
                endGame();
            }else{createQuestion(i);}
            
            

    
        }
        else if(e.getActionCommand().equals("stop"))
        {
            endGame();
        }
        else if(e.getActionCommand().equals("Wrong"))
        {
            scene.setBackground( new DVBColor(255, 0, 0, 200) );
            scene.setBackgroundMode( HVisible.BACKGROUND_FILL );
            intPoints--;
            lblPoints.setTextContent(Integer.toString(intPoints), HState.NORMAL_STATE);
            if(intPoints == -1){
                lblPoints.setTextContent("", HState.NORMAL_STATE);
                lblTotalPoints.setTextContent("Game Over!", HState.NORMAL_STATE);
                endGame();
            }
        }
    }
}

