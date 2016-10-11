package face;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * Creates a JFrame replication of the Mii Maker from the Wii.
 *
 * @author Daniel Kilgallon, John Gibson
 */
public class Face extends JFrame {

    //components of a mii
    private static final ArrayList<ImageIcon> EYEBROWS = new ArrayList<>();
    private static final ArrayList<ImageIcon> EYES = new ArrayList<>();
    private static final ArrayList<ImageIcon> HAIRS = new ArrayList<>();
    private static final ArrayList<ImageIcon> HAIR_SPRITES = new ArrayList<>();
    private static final ArrayList<ImageIcon> NOSES = new ArrayList<>();
    private static final ArrayList<ImageIcon> MOUTHS = new ArrayList<>();

    private final Mii MII = new Mii(setDefaultFace());

    private static final String[] CLIPS = {"MiiChannel", "MiiChannelPS", "MiiChannelHH",
        "MenuItemClick", "MouseOverButton", "ItemClick"};
    private static final int MII_CHANNEL_INDEX = 0;
    private static final int MII_CHANNELPS_INDEX = 1;
    private static final int MII_CHANNELHH_INDEX = 2;
    private static final int MENU_ITEM_CLICK_INDEX = 3;
    private static final int MOUSE_OVER_BUTTON_INDEX = 4;
    private static final int ITEM_CLICK_INDEX = 5;

    private static final Clip[] AUDIO_CLIPS = new Clip[CLIPS.length];

    //plays mouse over button sound
    private static final MouseAdapter MOUSE_OVER_LISTENER = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            AUDIO_CLIPS[MOUSE_OVER_BUTTON_INDEX].setFramePosition(0);
            AUDIO_CLIPS[MOUSE_OVER_BUTTON_INDEX].start();
        }
    };

    //sets what the user clicks to the mii and plays audio
    private final ActionListener ITEM_CLICK_LISTENER = (ActionEvent e) -> {
        AUDIO_CLIPS[ITEM_CLICK_INDEX].setFramePosition(0);
        AUDIO_CLIPS[ITEM_CLICK_INDEX].start();
        ItemButton temp = (ItemButton) e.getSource();
        for (ImageIcon eye : EYES) {
            if (temp.getIcon() == eye) {
                MII.setMiiEyes(eye);
            }
        }
        for (ImageIcon eyebrow : EYEBROWS) {
            if (temp.getIcon() == eyebrow) {
                MII.setMiiEyebrows(eyebrow);
            }
        }
        for (int i = 0; i < HAIR_SPRITES.size(); i++) {
            if (temp.getIcon() == HAIR_SPRITES.get(i)) {
                MII.setMiiHair(HAIRS.get(i));
            }
        }
        for (ImageIcon nose : NOSES) {
            if (temp.getIcon() == nose) {
                MII.setMiiNose(nose);
            }
        }
        for (ImageIcon mouth : MOUTHS) {
            if (temp.getIcon() == mouth) {
                MII.setMiiMouth(mouth);
            }
        }
    };

    private Clip activeMusic;

    /**
     * Default constructor
     */
    public Face() {
        setTitle("Mii Creator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1140, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(Face.class.getResource("Icon.png")).getImage());

        //load audio clips
        for (int i = 0; i < AUDIO_CLIPS.length; i++) {
            String fileName = "audio" + File.separator + CLIPS[i] + ".wav";
            InputStream stream = getClass().getResourceAsStream(fileName);
            BufferedInputStream bin = new BufferedInputStream(stream);
            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(bin);
                AudioFormat format = audioStream.getFormat();
                DataLine.Info info = new DataLine.Info(Clip.class, format);
                AUDIO_CLIPS[i] = (Clip) AudioSystem.getLine(info);
                AUDIO_CLIPS[i].open(audioStream);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(i);
                System.out.println(e);
            }
        }
        activeMusic = AUDIO_CLIPS[MII_CHANNEL_INDEX];
        AUDIO_CLIPS[MII_CHANNEL_INDEX].loop(1); //loop Mii Channel music
        AUDIO_CLIPS[MII_CHANNEL_INDEX].start(); //start Mii Channel music

        //load images
        //get directory listing
        File imageFolder = new File("src" + File.separator + "face" + File.separator + "images");
        File[] listOfFiles = imageFolder.listFiles();

        //load eyebrows
        for (File file : listOfFiles) {
            if (file.getName().contains("Eyebrow")) {
                try {
                    InputStream stream = new FileInputStream(file);
                    EYEBROWS.add(new ImageIcon(ImageIO.read(stream)));
                } catch (IOException ex) {
                    Logger.getLogger(Face.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        // load eyes
        for (File file : listOfFiles) {
            if (file.getName().contains("Eye") && !file.getName().contains("brow")) {
                try {
                    InputStream stream = new FileInputStream(file);
                    EYES.add(new ImageIcon(ImageIO.read(stream)));
                } catch (IOException ex) {
                    Logger.getLogger(Face.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        // load hairs
        for (File file : listOfFiles) {
            if (file.getName().contains("Hair") && !file.getName().contains("Sprite")) {
                try {
                    InputStream stream = new FileInputStream(file);
                    HAIRS.add(new ImageIcon(ImageIO.read(stream)));
                } catch (IOException ex) {
                    Logger.getLogger(Face.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        //load hair sprites
        for (File file : listOfFiles) {
            if (file.getName().contains("Hair") && file.getName().contains("Sprite")) {
                try {
                    InputStream stream = new FileInputStream(file);
                    HAIR_SPRITES.add(new ImageIcon(ImageIO.read(stream)));
                } catch (IOException ex) {
                    Logger.getLogger(Face.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        // load noses
        for (File file : listOfFiles) {
            if (file.getName().contains("Nose")) {
                try {
                    InputStream stream = new FileInputStream(file);
                    NOSES.add(new ImageIcon(ImageIO.read(stream)));
                } catch (IOException ex) {
                    Logger.getLogger(Face.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        // load mouths
        for (File file : listOfFiles) {
            if (file.getName().contains("Mouth")) {
                try {
                    InputStream stream = new FileInputStream(file);
                    MOUTHS.add(new ImageIcon(ImageIO.read(stream)));
                } catch (IOException ex) {
                    Logger.getLogger(Face.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        //removes action listener so user has to use our buttons for clicking between panes
        final JTabbedPane PANE = new JTabbedPane();
        for (MouseListener ml : PANE.getMouseListeners()) {
            PANE.removeMouseListener(ml);
            PANE.setFocusTraversalKeysEnabled(false);
            PANE.setFocusable(false);
        }

        PANE.add("Body Type", setBodyTypePanel());
        PANE.add("Hair", setHairPanel());
        PANE.add("Eyebrows", setEyebrowPanel());
        PANE.add("Eyes", setEyePane());
        PANE.add("Noses", setNosePanel());
        PANE.add("Mouths", setMouthPanel());
        PANE.add("Skin", setSkinPanel());
        PANE.add("Shirt", setShirtPanel());

        add(setJMenuBar(PANE), BorderLayout.NORTH);
        add(MII, BorderLayout.CENTER);
        add(PANE, BorderLayout.EAST);
        setVisible(true);
    }

    /**
     * Returns a JPanel with a height and weight slider to change the body type
     * of the mii
     */
    private JPanel setBodyTypePanel() {
        JPanel weightSliderPanel = new JPanel();
        final JSlider weightSlider = new JSlider(100, 150, 100);
        weightSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MII.setWeight(weightSlider.getValue());
            }
        });
        weightSliderPanel.add(weightSlider);
        weightSliderPanel.validate();
        weightSliderPanel.setBorder(new TitledBorder(new EtchedBorder(), "Weight"));

        JPanel heightSliderPanel = new JPanel();
        final JSlider heightSlider = new JSlider(130, 200, 150);
        heightSlider.setInverted(true);
        heightSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MII.setHeight(heightSlider.getValue());
            }
        });
        heightSliderPanel.add(heightSlider);
        heightSliderPanel.validate();
        heightSliderPanel.setBorder(new TitledBorder(new EtchedBorder(), "Height"));

        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.Y_AXIS));
        sliderPanel.add(weightSliderPanel);
        sliderPanel.add(heightSliderPanel);
        sliderPanel.add(Box.createVerticalGlue());
        sliderPanel.validate();
        sliderPanel.revalidate();
        sliderPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        return sliderPanel;
    }

    private JPanel setHairPanel() {
        JPanel hairPanel = new JPanel();
        hairPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        hairPanel.setLayout(new GridLayout(6, 2, 5, 5));
        for (ImageIcon icon : HAIR_SPRITES) {
            ItemButton ib = new ItemButton();
            ib.setIcon(icon);
            ib.addMouseListener(MOUSE_OVER_LISTENER);
            ib.addActionListener(ITEM_CLICK_LISTENER);
            hairPanel.add(ib);
        }
        return hairPanel;
    }

    /**
     * Returns a JPanel which has each changeable image and sliders for the
     * component of the mii face
     */
    private JPanel setEyebrowPanel() {
        JPanel eyebrowPanel = new JPanel();
        eyebrowPanel.setLayout(new BoxLayout(eyebrowPanel, BoxLayout.Y_AXIS));

        JLabel eyebrowLabelY = new JLabel("Eyebrow Height", SwingConstants.CENTER);
        final JSlider eyebrowSliderY = new JSlider(JSlider.VERTICAL, 15, 140, 40);
        eyebrowSliderY.setInverted(true);
        eyebrowSliderY.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MII.setMiiEyebrowOffsetY(eyebrowSliderY.getValue());
            }
        });

        JLabel eyebrowLabelX = new JLabel("Eyebrow Width", SwingConstants.CENTER);
        final JSlider eyebrowSliderX = new JSlider(-20, 20, 0);
        eyebrowSliderX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MII.setMiiEyebrowOffsetX(eyebrowSliderX.getValue());
            }
        });

        JPanel eyebrowPanelX = new JPanel();
        eyebrowPanelX.setLayout(new BorderLayout(5, 5));
        eyebrowPanelX.add(eyebrowLabelX, BorderLayout.NORTH);
        eyebrowPanelX.add(eyebrowSliderX, BorderLayout.CENTER);

        JPanel eyebrowPanelY = new JPanel();
        eyebrowPanelY.setLayout(new BorderLayout(5, 5));
        eyebrowPanelY.add(eyebrowLabelY, BorderLayout.NORTH);
        eyebrowPanelY.add(eyebrowSliderY, BorderLayout.CENTER);

        JPanel eyebrowSliderPanel = new JPanel();
        eyebrowPanelX.setLayout(new BoxLayout(eyebrowPanelX, BoxLayout.X_AXIS));
        eyebrowSliderPanel.add(eyebrowPanelX);
        eyebrowSliderPanel.add(eyebrowPanelY);

        JPanel eyebrowButtonPanel = new JPanel();
        eyebrowButtonPanel.setLayout(new GridLayout(4, 3, 5, 5));
        for (ImageIcon icon : EYEBROWS) {
            ItemButton ib = new ItemButton(icon);
            ib.setIcon(icon);
            ib.addMouseListener(MOUSE_OVER_LISTENER);
            ib.addActionListener(ITEM_CLICK_LISTENER);
            eyebrowButtonPanel.add(ib);
        }
        eyebrowPanel.add(eyebrowButtonPanel);
        eyebrowPanel.add(eyebrowSliderPanel);
        return eyebrowPanel;
    }

    /**
     * Returns a JPane which has each changeable image and sliders for the
     * component of the mii face
     */
    private JScrollPane setEyePane() {
        JPanel eyePanel = new JPanel();
        eyePanel.setLayout(new BoxLayout(eyePanel, BoxLayout.Y_AXIS));

        JLabel eyeLabelY = new JLabel("Eye Height", SwingConstants.CENTER);
        final JSlider eyeSliderY = new JSlider(JSlider.VERTICAL, 15, 130, 65);
        eyeSliderY.setInverted(true);
        eyeSliderY.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MII.setMiiEyeOffsetY(eyeSliderY.getValue());
            }
        });

        JLabel eyeLabelX = new JLabel("Eye Width", SwingConstants.CENTER);
        final JSlider eyeSliderX = new JSlider(-15, 30, 0);
        eyeSliderX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MII.setMiiEyeOffsetX(eyeSliderX.getValue());
            }
        });

        JPanel eyePanelX = new JPanel();
        eyePanelX.setLayout(new BorderLayout(5, 0));
        eyePanelX.add(eyeLabelX, BorderLayout.NORTH);
        eyePanelX.add(eyeSliderX, BorderLayout.CENTER);

        JPanel eyePanelY = new JPanel();
        eyePanelY.setLayout(new BorderLayout(5, 5));
        eyePanelY.add(eyeLabelY, BorderLayout.NORTH);
        eyePanelY.add(eyeSliderY, BorderLayout.CENTER);

        JPanel eyeSliderPanel = new JPanel();
        eyeSliderPanel.setLayout(new BoxLayout(eyeSliderPanel, BoxLayout.X_AXIS));
        eyeSliderPanel.add(eyePanelX);
        eyeSliderPanel.add(eyePanelY);

        JPanel eyeButtonPanel = new JPanel();
        eyeButtonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        eyeButtonPanel.setLayout(new GridLayout(12, 3, 5, 5));
        for (ImageIcon icon : EYES) {
            ItemButton ib = new ItemButton();
            ib.setIcon(icon);
            ib.addMouseListener(MOUSE_OVER_LISTENER);
            ib.addActionListener(ITEM_CLICK_LISTENER);
            eyeButtonPanel.add(ib);
        }
        eyePanel.add(eyeButtonPanel);
        eyePanel.add(eyeSliderPanel);
        JScrollPane eyePane = new JScrollPane(eyePanel);
        eyePane.setPreferredSize(new Dimension(229, 100));
        return eyePane;
    }

    /**
     * Returns a JPanel which has each changeable image and sliders for the
     * component of the mii face
     */
    private JPanel setNosePanel() {
        JPanel nosePanel = new JPanel();
        nosePanel.setLayout(new BoxLayout(nosePanel, BoxLayout.Y_AXIS));

        JLabel noseLabelY = new JLabel("Nose Height", SwingConstants.CENTER);
        final JSlider noseSliderY = new JSlider(JSlider.VERTICAL, 15, 120, 95);
        noseSliderY.setInverted(true);
        noseSliderY.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MII.setMiiNoseOffsetY(noseSliderY.getValue());
            }
        });

        JLabel noseLabelX = new JLabel("Nose Width", SwingConstants.CENTER);
        final JSlider noseSliderX = new JSlider(-155, -55, -105);
        noseSliderX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MII.setMiiNoseOffsetX(noseSliderX.getValue());
            }
        });

        JPanel noseSliderPanels = new JPanel();
        noseSliderPanels.setLayout(new BoxLayout(noseSliderPanels, BoxLayout.X_AXIS));

        JPanel noseSliderPanelX = new JPanel();
        noseSliderPanelX.setLayout(new BorderLayout(5, 0));
        noseSliderPanelX.add(noseLabelX, BorderLayout.NORTH);
        noseSliderPanelX.add(noseSliderX, BorderLayout.CENTER);

        JPanel noseSliderPanelY = new JPanel();
        noseSliderPanelY.setLayout(new BorderLayout(5, 5));
        noseSliderPanelY.add(noseLabelY, BorderLayout.NORTH);
        noseSliderPanelY.add(noseSliderY, BorderLayout.CENTER);

        JPanel noseButtonPanel = new JPanel();
        noseButtonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        noseButtonPanel.setLayout(new GridLayout(4, 3, 5, 5));
        for (ImageIcon icon : NOSES) {
            ItemButton ib = new ItemButton();
            ib.setIcon(icon);
            ib.addMouseListener(MOUSE_OVER_LISTENER);
            ib.addActionListener(ITEM_CLICK_LISTENER);
            noseButtonPanel.add(ib);
        }
        nosePanel.add(noseButtonPanel);
        noseSliderPanels.add(noseSliderPanelX);
        noseSliderPanels.add(noseSliderPanelY);
        nosePanel.add(noseSliderPanels);
        return nosePanel;
    }

    /**
     * Returns a JPanel which has each changeable image and sliders for the
     * component of the mii face
     */
    private JPanel setMouthPanel() {
        JLabel mouthLabelY = new JLabel("Mouth Height", SwingConstants.CENTER);
        final JSlider mouthSliderY = new JSlider(JSlider.VERTICAL, 60, 160, 145);
        mouthSliderY.setInverted(true);
        mouthSliderY.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MII.setMiiMouthOffsetY(mouthSliderY.getValue());
            }
        });

        JLabel mouthLabelX = new JLabel("Mouth Width", SwingConstants.CENTER);
        final JSlider mouthSliderX = new JSlider(-150, -55, -107);
        mouthSliderX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MII.setMiiMouthOffsetX(mouthSliderX.getValue());
            }
        });

        JPanel mouthPanelX = new JPanel();
        mouthPanelX.setLayout(new BorderLayout(5, 0));
        mouthPanelX.add(mouthLabelX, BorderLayout.NORTH);
        mouthPanelX.add(mouthSliderX, BorderLayout.CENTER);

        JPanel mouthPanelY = new JPanel();
        mouthPanelY.setLayout(new BorderLayout(5, 5));
        mouthPanelY.add(mouthLabelY, BorderLayout.NORTH);
        mouthPanelY.add(mouthSliderY, BorderLayout.CENTER);

        JPanel mouthPanel = new JPanel();
        mouthPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mouthPanel.setLayout(new GridLayout(7, 2, 5, 5));
        for (ImageIcon icon : MOUTHS) {
            ItemButton ib = new ItemButton();
            ib.setIcon(icon);
            ib.addMouseListener(MOUSE_OVER_LISTENER);
            ib.addActionListener(ITEM_CLICK_LISTENER);
            mouthPanel.add(ib);
        }
        mouthPanel.add(mouthPanelX);
        mouthPanel.add(mouthPanelY);
        return mouthPanel;
    }

    /**
     * Returns a JPanel of each possible skin color for mii to have
     */
    private JPanel setSkinPanel() {
        final Color[] skinColors = {new Color(255, 220, 118),
            new Color(255, 195, 0),
            new Color(255, 121, 0),
            new Color(255, 172, 99),
            new Color(233, 71, 0),
            new Color(114, 54, 0)};

        JPanel skinPanel = new JPanel();
        JPanel skinButtonsPanel = new JPanel();
        skinButtonsPanel.setLayout(new GridLayout(2, 3, 5, 5));
        for (final Color skinColor : skinColors) {
            ItemButton ib = new ItemButton();
            ActionListener skinButtonListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MII.setSkinColor(skinColor);
                    AUDIO_CLIPS[MENU_ITEM_CLICK_INDEX].setFramePosition(0);
                    AUDIO_CLIPS[MENU_ITEM_CLICK_INDEX].start();
                    repaint();
                }
            };
            ib.addMouseListener(MOUSE_OVER_LISTENER);
            ib.addActionListener(ITEM_CLICK_LISTENER);
            ib.addActionListener(skinButtonListener);
            ib.setBackgroundColor(skinColor);
            skinButtonsPanel.add(ib);
        }
        skinPanel.add(skinButtonsPanel);
        skinPanel.add(Box.createVerticalGlue());
        return skinPanel;
    }

    /**
     * Returns A JPanel of each possible shirt color for mii to have
     */
    private JPanel setShirtPanel() {
        JPanel shirtPanel = new JPanel();
        //colors to choose from
        final Color[] shirtColors = {new Color(230, 89, 77),
            new Color(249, 160, 98),
            new Color(255, 224, 91),
            new Color(186, 218, 97),
            new Color(65, 138, 84),
            new Color(57, 105, 228),
            new Color(139, 211, 251),
            new Color(255, 138, 160),
            new Color(159, 102, 200),
            new Color(117, 99, 63),
            Color.WHITE,
            Color.BLACK};

        JPanel shirtButtonsPanel = new JPanel();
        shirtButtonsPanel.setLayout(new GridLayout(4, 3, 5, 5));
        for (final Color shirtColor : shirtColors) {
            ItemButton ib = new ItemButton();
            ActionListener shirtButtonListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MII.setFavoriteColor(shirtColor);
                    AUDIO_CLIPS[MENU_ITEM_CLICK_INDEX].setFramePosition(0);
                    AUDIO_CLIPS[MENU_ITEM_CLICK_INDEX].start();
                    repaint();
                }
            };
            ib.addMouseListener(MOUSE_OVER_LISTENER);
            ib.addActionListener(ITEM_CLICK_LISTENER);
            ib.addActionListener(shirtButtonListener);
            ib.setBackgroundColor(shirtColor);
            shirtButtonsPanel.add(ib);
        }
        shirtPanel.add(shirtButtonsPanel);
        shirtPanel.add(Box.createVerticalGlue());
        return shirtPanel;
    }

    /**
     * Returns the JMenuBar to buttons with listeners
     *
     * @param pane the pane to add the JMenuBar too
     */
    private JMenuBar setJMenuBar(final JTabbedPane pane) {
        final JMenuBar menuBar = new JMenuBar();
        final JMenuItem bodyMenu = new JMenuItem("BodyType");
        final JMenuItem hairMenu = new JMenuItem("Hairs");
        final JMenuItem eyebrowMenu = new JMenuItem("Eyebrows");
        final JMenuItem eyeMenu = new JMenuItem("Eyes");
        final JMenuItem noseMenu = new JMenuItem("Noses");
        final JMenuItem mouthMenu = new JMenuItem("Mouths");
        final JMenuItem skinMenu = new JMenuItem("Skin");
        final JMenuItem shirtMenu = new JMenuItem("Shirt");
        //the fubar button
        final JButton foo = new JButton("  ");
        foo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Does the Fubar main method
                Fubar.main(null);
            }
        });
        foo.setToolTipText("DR. COLES DON'T PUSH THIS.");
        foo.setFocusPainted(false);
        foo.setContentAreaFilled(false);
        final JButton muteMusic = new JButton("Mute Music");
        final JButton changeMusic = new JButton("Change Music");
        //styles the buttons to have no bubbling effect
        changeMusic.setFocusPainted(false);
        changeMusic.setContentAreaFilled(false);
        changeMusic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame musicWheel = new JFrame("Choose Music");
                musicWheel.setSize(900, 300);
                musicWheel.setLocationRelativeTo(null);
                JPanel musicPanel = new JPanel();
                musicPanel.setLayout(new GridLayout(1, 3, 10, 10));
                final JButton miiChannel = new JButton(new ImageIcon(new ImageIcon(
                        Face.class.getResource("Mii.png")).getImage()
                        .getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
                final JButton miiChannelHH = new JButton(new ImageIcon(new ImageIcon(
                        Face.class.getResource("MiiHH.png")).getImage()
                        .getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
                final JButton miiChannelPS = new JButton(new ImageIcon(new ImageIcon(
                        Face.class.getResource("MiiScary.png")).getImage()
                        .getScaledInstance(300, 300, Image.SCALE_SMOOTH)));

                musicPanel.add(miiChannel);
                musicPanel.add(miiChannelPS);
                musicPanel.add(miiChannelHH);

                //change music button listener
                ActionListener aListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton button = (JButton) e.getSource();
                        for (Clip c : AUDIO_CLIPS) {
                            c.stop();
                        }
                        for (Clip c : AUDIO_CLIPS) {
                            if (button == miiChannel) {
                                c = AUDIO_CLIPS[MII_CHANNEL_INDEX];
                                if (!c.isActive()) {
                                    c.setFramePosition(0);
                                    activeMusic = c;
                                    activeMusic.start();
                                }
                            } else if (button == miiChannelPS) {
                                c = AUDIO_CLIPS[MII_CHANNELPS_INDEX];
                                if (!c.isActive()) {
                                    c.setFramePosition(0);
                                    activeMusic = c;
                                    activeMusic.start();
                                }
                            } else if (button == miiChannelHH) {
                                c = AUDIO_CLIPS[MII_CHANNELHH_INDEX];
                                if (!c.isActive()) {
                                    c.setFramePosition(0);
                                    activeMusic = c;
                                    activeMusic.start();
                                }
                            }
                        }
                    }
                };
                miiChannel.addActionListener(aListener);
                miiChannelPS.addActionListener(aListener);
                miiChannelHH.addActionListener(aListener);
                musicWheel.add(musicPanel);
                musicWheel.setVisible(true);
            }
        });
        //styles the buttons to have no bubbling effect
        muteMusic.setFocusPainted(false);
        muteMusic.setContentAreaFilled(false);
        muteMusic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Clip c : AUDIO_CLIPS) {
                    if (c == activeMusic && activeMusic.isActive()) {
                        activeMusic.stop();
                        muteMusic.setText("Unmute Music");
                    } else if (c == activeMusic) {
                        activeMusic.start();
                        muteMusic.setText("Mute Music");
                    }
                }
            }
        });

        //JMenu "buttons" listener
        MouseAdapter listener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JMenuItem temp = (JMenuItem) e.getComponent();
                if (temp.getText().equals("BodyType")) {
                    pane.setSelectedIndex(0);
                } else if (temp.getText().equals("Hairs")) {
                    pane.setSelectedIndex(1);
                } else if (temp.getText().equals("Eyebrows")) {
                    pane.setSelectedIndex(2);
                } else if (temp.getText().equals("Eyes")) {
                    pane.setSelectedIndex(3);
                } else if (temp.getText().equals("Noses")) {
                    pane.setSelectedIndex(4);
                } else if (temp.getText().equals("Mouths")) {
                    pane.setSelectedIndex(5);
                } else if (temp.getText().equals("Skin")) {
                    pane.setSelectedIndex(6);
                } else if (temp.getText().equals("Shirt")) {
                    pane.setSelectedIndex(7);
                }
                AUDIO_CLIPS[MENU_ITEM_CLICK_INDEX].setFramePosition(0);
                AUDIO_CLIPS[MENU_ITEM_CLICK_INDEX].start();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                AUDIO_CLIPS[MOUSE_OVER_BUTTON_INDEX].setFramePosition(0);
                AUDIO_CLIPS[MOUSE_OVER_BUTTON_INDEX].start();
            }
        };

        bodyMenu.addMouseListener(listener);
        hairMenu.addMouseListener(listener);
        eyeMenu.addMouseListener(listener);
        noseMenu.addMouseListener(listener);
        mouthMenu.addMouseListener(listener);
        eyebrowMenu.addMouseListener(listener);
        skinMenu.addMouseListener(listener);
        shirtMenu.addMouseListener(listener);

        menuBar.add(bodyMenu);
        menuBar.add(hairMenu);
        menuBar.add(eyebrowMenu);
        menuBar.add(eyeMenu);
        menuBar.add(noseMenu);
        menuBar.add(mouthMenu);
        menuBar.add(skinMenu);
        menuBar.add(shirtMenu);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(foo);
        menuBar.add(changeMusic);
        menuBar.add(muteMusic);
        return menuBar;
    }

    /**
     * Returns the default face with imageicons
     *
     * @return an array of images for a standard face. {eye, eyebrow, nose,
     * mouth, hair}
     */
    private ImageIcon[] setDefaultFace() {
        //Creates a default face for the mii to have
        try {
            InputStream eyeStream = new FileInputStream(new File("src/face/images/Eye1.png"));
            ImageIcon eye = (new ImageIcon(ImageIO.read(eyeStream)));

            InputStream eyeBrowStream = new FileInputStream(new File("src/face/images/Eyebrow1.png"));
            ImageIcon eyebrow = (new ImageIcon(ImageIO.read(eyeBrowStream)));

            InputStream noseStream = new FileInputStream(new File("src/face/images/Nose1.png"));
            ImageIcon nose = (new ImageIcon(ImageIO.read(noseStream)));

            InputStream mouthStream = new FileInputStream(new File("src/face/images/Mouth1.png"));
            ImageIcon mouth = (new ImageIcon(ImageIO.read(mouthStream)));

            InputStream hairStream = new FileInputStream(new File("src/face/images/Hair1.png"));
            ImageIcon hair = (new ImageIcon(ImageIO.read(hairStream)));

            ImageIcon[] temp = {eye, eyebrow, nose, mouth, hair};
            return temp;
        } catch (FileNotFoundException fnfe) {
            Logger.getLogger(Face.class.getName()).log(Level.SEVERE, null, fnfe);
        } catch (IOException ioe) {
            Logger.getLogger(Face.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return null;  //unreachable as long as images are in correct location
    }

    /**
     * Used Advanced Features: TabbedPanes, JScrollBar, Audio IO, Extending
     * Basic Button UI
     */
    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException 
                | UnsupportedLookAndFeelException e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        Face face = new Face(); //Create and show the GUI.
    }
}
