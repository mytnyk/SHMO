
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.Enumeration;

public class main extends JDialog implements ActionListener, ChangeListener, ItemListener {
    private JBGPanel contentPane;
    private JButton buttonEXIT;
    private JBRadioButton dN;
    private JBRadioButton dNNE;
    private JBRadioButton dNE;
    private JBRadioButton dENE;
    private JBRadioButton dE;
    private JBRadioButton dESE;
    private JBRadioButton dSE;
    private JBRadioButton dSSE;
    private JBRadioButton dS;
    private JBRadioButton dSSW;
    private JBRadioButton dSW;
    private JBRadioButton dWSW;
    private JBRadioButton dW;
    private JBRadioButton dWNW;
    private JBRadioButton dNW;
    private JBRadioButton dNNW;
    private final ButtonGroup dgroup;
    private JBLabel waveheight;
    private JSpinner wind_speed;

    public main() {

        this.setTitle("ÏÐÎÃÍÎÇ ÂÎËÍÅÍÈß Â ÑÅÂÀÑÒÎÏÎËÜÑÊÎÉ ÁÓÕÒÅ");
        buttonEXIT = new JButton("ÂÛÕÎÄ");

        dgroup = new ButtonGroup();
        dgroup.add(dN = new JBRadioButton("Ñ", true));
        dgroup.add(dNNE = new JBRadioButton("ÑÑÂ", false));
        dgroup.add(dNE = new JBRadioButton("ÑÂ", false));
        dgroup.add(dENE = new JBRadioButton("ÂÑÂ", false));
        dgroup.add(dE = new JBRadioButton("Â", false));
        dgroup.add(dESE = new JBRadioButton("ÂÞÂ", false));
        dgroup.add(dSE = new JBRadioButton("ÞÂ", false));
        dgroup.add(dSSE = new JBRadioButton("ÞÞÂ", false));
        dgroup.add(dS = new JBRadioButton("Þ", false));
        dgroup.add(dSSW = new JBRadioButton("ÞÞÇ", false));
        dgroup.add(dSW = new JBRadioButton("ÞÇ", false));
        dgroup.add(dWSW = new JBRadioButton("ÇÞÇ", false));
        dgroup.add(dW = new JBRadioButton("Ç", false));
        dgroup.add(dWNW = new JBRadioButton("ÇÑÇ", false));
        dgroup.add(dNW = new JBRadioButton("ÑÇ", false));
        dgroup.add(dNNW = new JBRadioButton("ÑÑÇ", false));

        JTPanel directionPane = new JTPanel(new GridLayout(5, 5));

        directionPane.add(dNW);
        directionPane.add(dNNW);
        directionPane.add(dN);
        directionPane.add(dNNE);
        directionPane.add(dNE);

        directionPane.add(dWNW);
        directionPane.add(new JPanel());
        directionPane.add(new JPanel());
        directionPane.add(new JPanel());
        directionPane.add(dENE);

        directionPane.add(dW);
        directionPane.add(new JPanel());
        directionPane.add(new JPanel());
        directionPane.add(new JPanel());
        directionPane.add(dE);

        directionPane.add(dWSW);
        directionPane.add(new JPanel());
        directionPane.add(new JPanel());
        directionPane.add(new JPanel());
        directionPane.add(dESE);

        directionPane.add(dSW);
        directionPane.add(dSSW);
        directionPane.add(dS);
        directionPane.add(dSSE);
        directionPane.add(dSE);

        JTPanel directionPaneLabelHolder = new JTPanel();
        directionPaneLabelHolder.add(new JBLabel("<html><body><center>ÍÀÏÐÀÂËÅÍÈÅ ÂÅÒÐÀ<p>(ðóìá)</center></body></html>"));

        JTPanel directionPaneHolder = new JTPanel();
        directionPaneHolder.add(directionPane);

        JTPanel directionPaneWithLabel = new JTPanel(new BorderLayout());
        directionPaneWithLabel.add(directionPaneLabelHolder, BorderLayout.NORTH);
        directionPaneWithLabel.add(directionPaneHolder, BorderLayout.CENTER);

        JTPanel speedPaneHolder = new JTPanel();
        speedPaneHolder.add(new JBLabel("<html><body><center>ÑÊÎÐÎÑÒÜ ÂÅÒÐÀ<p>(ñðåäíÿÿ, ì/ñ)</center></body></html>"));

        JTPanel speedPaneLabelHolder = new JTPanel();
        SpinnerNumberModel speed_spinner_model = new SpinnerNumberModel(2.0, 0.1, 30.0, 0.1);
        speedPaneLabelHolder.add(wind_speed = new JSpinner(speed_spinner_model));
        wind_speed.setFont(new Font("Helvetica", Font.BOLD, 20));

        JTPanel speedPane = new JTPanel(new GridLayout(2, 1));
        speedPane.add(speedPaneHolder);
        speedPane.add(speedPaneLabelHolder);

        JTPanel heightPaneHolder = new JTPanel();
        heightPaneHolder.add(new JBLabel("<html><body><center>ÂÛÑÎÒÀ ÂÎËÍÛ<p>(ñðåäíÿÿ, ì)<p>(95% èíòåðâàë)</center></body></html>", new Color(128, 0, 0)));

        JTPanel heightPaneLabelHolder = new JTPanel();
        heightPaneLabelHolder.add(waveheight = new JBLabel("height", new Color(128, 0, 0)));

        JTPanel heightPane = new JTPanel(new GridLayout(2, 1));
        heightPane.add(heightPaneHolder);
        heightPane.add(heightPaneLabelHolder);

        JTPanel speedandheightPane = new JTPanel(new GridLayout(2, 1));
        speedandheightPane.add(speedPane);
        speedandheightPane.add(heightPane);

        JTPanel workPane = new JTPanel(new BorderLayout());
        workPane.add(directionPaneWithLabel, BorderLayout.WEST);
        workPane.add(speedandheightPane, BorderLayout.CENTER);

        JTPanel infoPane = new JTPanel(new FlowLayout(FlowLayout.RIGHT));
        infoPane.add(new JLabel("Copyright (c) 2005-2008 Ìûòíèê Î.Þ.           "));
        infoPane.add(buttonEXIT);

        contentPane = new JBGPanel(new BorderLayout());
        contentPane.add(workPane, BorderLayout.CENTER);
        contentPane.add(infoPane, BorderLayout.SOUTH);
        //contentPane.setBorder(BorderFactory.createEtchedBorder());
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonEXIT);

        // add listeners
        buttonEXIT.addActionListener(this);
        speed_spinner_model.addChangeListener(this);

        Enumeration<AbstractButton> btn_enum = dgroup.getElements();
        while (btn_enum.hasMoreElements())
        {
            JRadioButton btn = (JRadioButton)btn_enum.nextElement();
            btn.addItemListener(this);
        }

        // make transparent
        for (int i = 0; i < directionPane.getComponentCount(); i++)
        {
            ((JComponent)directionPane.getComponent(i)).setOpaque(false);
        }
        //buttonEXIT.setContentAreaFilled(false);

        CalculateHeight();
    }

    public static void main(String[] args) {
        main dialog = new main();
        dialog.setSize(560, 460);
        dialog.setResizable(false);
        dialog.setVisible(true);
        System.exit(0);
    }

    public void actionPerformed(ActionEvent e) {
        final String label = e.getActionCommand();
        if (label.equals("ÂÛÕÎÄ"))
        {
            System.exit(0);
        }
    }

    public void stateChanged(ChangeEvent e) {
        CalculateHeight();
    }

    public void itemStateChanged(ItemEvent e) {
        CalculateHeight();
    }

    private void CalculateHeight()
    {
        String wind_direction = "";
        Enumeration<AbstractButton> btn_enum = dgroup.getElements();
        while (btn_enum.hasMoreElements())
        {
            JRadioButton btn = (JRadioButton)btn_enum.nextElement();
            if (btn.isSelected())
            {
                wind_direction = btn.getText();
                break;
            }
        }
        double[] waveheight_values = HardcodedModel(ConvertDirection(wind_direction), ((Number)wind_speed.getValue()).doubleValue());
        double lb = waveheight_values[0] - 2*waveheight_values[1];
        if (lb < 0.0) lb = 0.0;
        double ub = waveheight_values[0] + 2*waveheight_values[1];
        if (waveheight_values[0] < 0) waveheight_values[0] = 0;
        waveheight.setText(formatDouble(waveheight_values[0], 2) + " (" + formatDouble(lb, 2)
                + " ~ " + formatDouble(ub, 2)+ ")");

    }

    private double[] HardcodedModel(final double angle, final double speed)
    {
        final double eps = 0.02;
        final double U = 10;
        final double sigma2n = 2/(U*U)+eps*eps*(eps*U+3)/(3*(eps*U+1));
        final double sigma = Math.sqrt(sigma2n)*(2.4 - 0.1);
        // normalize speed
        final double normal_speed = (speed - 1.0)/(14.0 - 1.0); // max speed = 14, min speed = 1
        // convert angle to radians
        final double angle_rad = angle/180.0*Math.PI;
        // apply hardcoded model
        double normal_height = 0.47 + 0.09*(1 - Math.sin(angle_rad)) - 0.09*Math.sin(angle_rad) - 0.04*(1 - Math.cos(angle_rad)) +
                0.04*Math.cos(angle_rad) - 0.35*(1 - normal_speed) + 0.35*(normal_speed);
        // de-normalize wave height
        double[] retval = new double[2];
        retval[0] = 0.1 + (normal_height)*(2.4 - 0.1); // max height = 2.4, min height = 0.1
        retval[1] = sigma;
        return retval;
    }

    private static double ConvertDirection(String rhumb)
    {
      if (rhumb == "Ñ")
        return 0.0;
      else if (rhumb == "ÑÑÂ")
        return 22.5;
      else if (rhumb == "ÑÂ")
        return 45.0;
      else if (rhumb == "ÂÑÂ")
        return 67.5;
      else if (rhumb == "Â")
        return 90.0;
      else if (rhumb == "ÂÞÂ")
        return 112.5;
      else if (rhumb == "ÞÂ")
        return 135.0;
      else if (rhumb == "ÞÞÂ")
        return 157.5;
      else if (rhumb == "Þ")
        return 180.0;
      else if (rhumb == "ÞÞÇ")
        return 202.5;
      else if (rhumb == "ÞÇ")
        return 225.0;
      else if (rhumb == "ÇÞÇ")
        return 247.5;
      else if (rhumb == "Ç")
        return 270.0;
      else if (rhumb == "ÇÑÇ")
        return 292.5;
      else if (rhumb == "ÑÇ")
        return 315.0;
      else if (rhumb == "ÑÑÇ")
        return 337.5;

      return 0.0;
    }

    public static String formatDouble(final double d, final int iPrecision) {
        int p = (int) Math.pow(10, iPrecision);
        return Double.toString(Math.floor(d * p + 0.5d) / p);
    }

    /* Transparent Panel
    */
    class JTPanel extends JPanel
    {
      public JTPanel()
      {
          this(new FlowLayout(FlowLayout.CENTER));
      }
      public JTPanel(LayoutManager layout)
      {
      super(layout);
      setOpaque(false);
      }
    }

    class JBGPanel extends JPanel
    {
      private Image grayImage;
      public JBGPanel(LayoutManager layout)
        {
        super(layout);

        ImageIcon imageIcon = new ImageIcon(main.class.getResource("/res/SB.GIF"));
        Image image = imageIcon.getImage();
        grayImage = GrayFilter.createDisabledImage(image);
        setOpaque(false);
        }
      public void paintComponent (Graphics g) {
        g.drawImage(grayImage, 0, 0, this);
        super.paintComponent(g);
      }
    }

    class JBLabel extends JLabel
    {
        public JBLabel(String text, Color color)
        {
            this(text);
            setForeground(color);
        }
        public JBLabel(String text)
        {
            super(text);
            setFont(new Font("Helvetica", Font.BOLD, 20));
        }
    }

    class JBRadioButton extends JRadioButton
    {
        public JBRadioButton(String text, boolean selected)
        {
            super(text, selected);
            setFont(new Font("Helvetica", Font.BOLD, 15));
        }
    }
}
