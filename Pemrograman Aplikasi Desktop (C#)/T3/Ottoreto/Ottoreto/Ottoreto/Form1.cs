using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime.ConstrainedExecution;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.Rebar;

namespace Ottoreto
{
    public partial class Form1 : Form
    {

        List<Button> sequenceList;
        bool playing;
        bool resetted;
        int skor;
        int counter;
        Button[,] buttonArr = new Button[10, 4];
        Color[] colors = { Color.Yellow, Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Red, Color.Green, Color.Blue,Color.Yellow, Color.Black };
        public Form1()
        {
            InitializeComponent();
            initialGenerate();
            playing = false;
            skor = 0;
            counter = 0;
            resetted=false;
        }

        public void initialGenerate()
        {
            int x = 28;
            int y = 28;
            sequenceList = new List<Button>();
            for(int i = 0; i < 8; i++)
            {
                Button b = new Button();
                b.Parent = Sequence;
                b.FlatStyle = FlatStyle.Flat;
                b.BackColor = Color.White;
                b.Height = 35;
                b.Width = 40;
                b.Enabled = false;
                b.Location = new Point(x, y);
                b.Tag=" ";
                sequenceList.Add(b);
                Sequence.Controls.Add(b);
                x += 45;
            }
            Console.WriteLine(sequenceList.Count);
        }

        public void generate()
        {
            Random rand = new Random();
            if (!resetted)
            {
                int x = 27;
                int y = 76;
                for (int i = 0; i < 10; i++)
                {
                    // i = y
                    // j = x
                    x = 27;
                    for (int j = 0; j < 4; j++)
                    {
                        int dex = rand.Next(0, 10);
                        Button b = new Button();
                        b.Height = 35;
                        b.Width = 40;
                        b.FlatStyle = FlatStyle.Flat;
                        b.BackColor = colors[dex];
                        b.Enabled = true;
                        b.Parent = this;
                        b.Click += onClick;
                        b.Location = new Point(x, y);
                        b.Tag = i + "" + j;
                        buttonArr[i, j] = b;
                        x += 45;
                    }
                    y += 40;
                }
            }
            else
            {
                for (int i = 0; i < 10; i++)
                {
                    for (int j = 0; j < 4; j++)
                    {
                        int dex = rand.Next(0, 10);
                        buttonArr[i, j].Visible = true;
                        buttonArr[i, j].Enabled = true;
                        buttonArr[i,j].BackColor = colors[dex];
                    }
                }
            }
        }

        public void onClick(object sender, EventArgs e)
        {
            Button b = (Button)sender;
            Color c = new Color();
            c = b.BackColor;
            

            if (sequenceList[0].BackColor == Color.White)
            {
                sequenceList[0].BackColor = c;
                sequenceList[0].Tag = b.Tag;
                b.Text = Convert.ToString(counter + 1);
                if (c != Color.Yellow)
                {
                    b.ForeColor = Color.White;
                }
                counter++;
            }
            else
            {
                bool sudah = false;
                bool tetangga = false;
                String temp = b.Tag.ToString();
                int x = Convert.ToInt32(temp[1]);
                int y = Convert.ToInt32(temp[0]);

                string tar = sequenceList[counter - 1].Tag.ToString();
                int x2= Convert.ToInt32(tar[1]);
                int y2 = Convert.ToInt32(tar[0]);

                if (Math.Abs(x - x2) == 1 && y==y2 || Math.Abs(y - y2) == 1 && x==x2)
                {
                    tetangga = true;   
                }

                foreach (Button btn in sequenceList)
                {
                    if (btn.Tag==b.Tag)
                    {
                        sudah=true;
                    }
                
                }

                if (c != Color.White && counter < 8 && tetangga &&!sudah)
                {
                    sequenceList[counter].BackColor = c;
                    sequenceList[counter].Tag = b.Tag;
                    b.Text = Convert.ToString(counter + 1);
                    if (c != Color.Yellow)
                    {
                        b.ForeColor = Color.White;
                    }
                    counter++;
                }
                else if (sudah)
                {
                    if (sequenceList[counter-1].BackColor != Color.White)
                    {
                        sequenceList[counter-1].BackColor = Color.White;
                        sequenceList[counter-1].ForeColor = Color.Black;
                        sequenceList[counter-1].Tag = " ";
                        b.Text = "";
                        b.ForeColor = Color.Black;
                        counter--;
                    }
                }
            }
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        public void resetBox()
        {
            for (int i = 0; i < 10; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    buttonArr[i,j].Visible = false;
                    buttonArr[i,j].Enabled = false;
                }
            }
        }

        private void StartStopBtn_Click(object sender, EventArgs e)
        {
            if (playing)
            {
                playing = false;
                StartStopBtn.Text = "Play";
                ResetBtn.Enabled = false;
                SubmitBtn.Enabled = false;
                resetted = true;
                resetBox();
            }
            else
            {
                StartStopBtn.Text = "Exit";
                playing = true;
                ResetBtn.Enabled = true;
                SubmitBtn.Enabled = true;
                SkorLabel.Text = "0";
                NameTB.Enabled = false;
                generate();
            }
        }

        private void NameTB_TextChanged(object sender, EventArgs e)
        {
            if (NameTB.Text.Length > 0)
            {
                StartStopBtn.Enabled = true;

            }
            else
            {
                StartStopBtn.Enabled = false;
            }
        }

        private void ResetBtn_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < 10; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    buttonArr[i, j].Text = "";
                }
            }
            foreach (Button b in sequenceList)
            {
                b.Tag = "";
                b.BackColor = Color.White;
            }
            counter = 0;
        }

        public bool isPalindrome(string p)
        {
            string first = p.Substring(0, p.Length / 2);
            char[] arr = p.ToCharArray();

            Array.Reverse(arr);

            string temp = new string(arr);
            string second = temp.Substring(0, temp.Length / 2);

            return first.Equals(second);
        }

        public void destroy()
        {
            foreach (Button b in sequenceList)
            {
                if(b.Tag.ToString().Length>1)
                {
                    string coordinate = b.Tag.ToString();
                    char[] arr = coordinate.ToCharArray();
                    int x = arr[0] - '0'; //Convert int menggunakan ASCII value.
                    int y = arr[1] - '0';
                    Console.WriteLine(x);
                    Console.WriteLine(y);
                    if (buttonArr[x, y].BackColor != Color.Yellow)
                    {
                        buttonArr[x, y].ForeColor = Color.Black;
                    }
                    buttonArr[x,y].BackColor = Color.White;
                    
                }
            }
        }

        public void addScore()
        {
            this.skor++;
        }

        public bool containsBomb(string p)
        {
            return p.Contains("X");
        }

        public void explode(Button b)
        {
            if (b.BackColor != Color.White)
            {
                b.BackColor = Color.White;
                if (b.BackColor != Color.Yellow)
                {
                    b.ForeColor = Color.Black;
                }
                b.Text = "";
            }
        }

        private void SubmitBtn_Click(object sender, EventArgs e)
        {
            string palindrom="";
            foreach (Button b in sequenceList)
            {
                if (b.BackColor != Color.White)
                {
                    if(b.BackColor == Color.Yellow)
                    {
                        palindrom += "Y";
                    }
                    else if (b.BackColor == Color.Red)
                    {
                        palindrom += "R";
                    }
                    else if (b.BackColor == Color.Green)
                    {
                        palindrom += "G";
                    }
                    else if(b.BackColor == Color.Blue)
                    {
                        palindrom += "B";
                    }
                    else if(b.BackColor == Color.Black)
                    {
                        palindrom += "X";
                    }
                }
                else
                {
                    break;
                }
            }
            if (isPalindrome(palindrom))
            {
                if (containsBomb(palindrom))
                {
                    List<int> listbomb = new List<int>();
                    for (int i = 0; i < palindrom.Length; i++)
                    {
                        if (palindrom[i] == 'X')
                        {
                            listbomb.Add(i);
                        }
                    }
                    foreach (int i in listbomb)
                    {
                        string tar = sequenceList[i].Tag.ToString();
                        char[] arr = tar.ToCharArray();
                        int x = arr[1] - '0';
                        int y = arr[0] - '0';
                        int xp = x + 1;
                        int xm = x - 1;
                        int yp = y + 1;
                        int ym = y - 1;
                        if (xp < 4)
                        {
                            explode(buttonArr[y, xp]);
                        }
                        if (xm > -1)
                        {
                            explode(buttonArr[y, xm]);
                        }
                        if(yp < 10)
                        {
                            explode(buttonArr[yp, x]);
                        }
                        if(ym > -1)
                        {
                            explode(buttonArr[ym, x]);
                        }
                        if(ym>-1&& xm > -1)
                        {
                            explode(buttonArr[ym, xm]);
                        }
                        if(ym > -1&& xp < 4)
                        {
                            explode(buttonArr[ym, xp]);
                        }
                        if(yp < 10&& xm > -1)
                        {
                            explode(buttonArr[yp, xm]);
                        }
                        if (yp < 10 && xp < 4)
                        {
                            explode(buttonArr[yp, xp]);
                        }

                        buttonArr[y, x].BackColor = Color.White;
                        buttonArr[y, x].ForeColor = Color.Black;
                    }
                    ResetBtn_Click(ResetBtn, e);
                }
                else
                {
                    destroy();
                    //this.ResetBtn.PerformClick();
                    ResetBtn_Click(ResetBtn, e);
                }
                counter = 0;

            }
            else
            {

            }
        }
    }
}
