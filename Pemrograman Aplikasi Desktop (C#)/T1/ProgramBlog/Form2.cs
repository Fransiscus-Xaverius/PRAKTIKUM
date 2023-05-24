using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProgramBlog
{
    public partial class Form2 : Form
    {
        List<User> listuser;
        int totalContentCount;
        Content selectedContent = null;
        User curUser;
        int totalfound;
        List<Content> found;
        public Form2()
        {
            InitializeComponent();
            this.listuser = new List<User>();
            curUser = null;
            updateCounter();
            LoginState();
        }

        public Form2(List<User> listuser)
        {
            InitializeComponent();
            this.listuser = listuser;
            curUser = null;
            updateCounter();
            LoginState();
        }

        public void updateCounter()
        {
            totalContentCount = 0;
            foreach (User u in listuser)
            {
                totalContentCount += u.getContent().Count;
            }
            TotalResultFoundLabel.Text = $"0/{totalContentCount} Result Found";
            progressBar1.Maximum = totalContentCount;
        }

        private void Form2_Load(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void cToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form1 creatorForm = new Form1(listuser);
            this.Hide();
            creatorForm.Show();
        }

        private void Form2_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }

        private void LoginState()
        {
            if (curUser != null)
            {
                LoginBtn.Text = "Log Out";
                LikeBtn.Enabled = true;
                textBox1.Enabled = false;
                textBox2.Enabled = false;
            }
            else
            {
                LoginBtn.Text = "Login";
                LikeBtn.Enabled = false;
                textBox1.Enabled = true;
                textBox2.Enabled = true;
            }
        }



        private void LoginBtn_Click(object sender, EventArgs e)
        {
            if(curUser != null)
            {
                curUser = null;
                LoginState();
            }
            else
            {
                string logUser = textBox1.Text;
                string logPass = textBox2.Text;
                if (listuser != null)
                {
                    foreach (User u in listuser)
                    {
                        if (u.getUsername() == logUser && u.getPassword() == logPass)
                        {
                            curUser = u;
                            LoginState();
                        }
                    }
                    
                }
                if(curUser== null)
                {
                    MessageBox.Show("Username/Password Salah/Tidak terdaftar!");
                }
                else
                {
                    if (selectedContent != null)
                    {
                        if (selectedContent.isLiked(curUser.getUsername()))
                        {
                            LikeBtn.Text = "Unlike";
                        }
                        else
                        {
                            LikeBtn.Text = "Like";
                        }
                    }
                }
            }
        }

        private void SearchBtn_Click(object sender, EventArgs e)
        {
            string keyword = SearchTB.Text;
            totalfound = 0;
            ResultListBox.Items.Clear();
            found = new List<Content>();
            foreach (User u in listuser)
            {
                List<Content> curUserContent = u.getContent();
                foreach (Content c in curUserContent)
                {
                    if (c.Title.ToLower().Contains(keyword.ToLower()) || c.Isi.ToLower().Contains(keyword.ToLower()))
                    {
                        found.Add(c);
                    }
                }
            }
            totalfound = found.Count;
            progressBar1.Value = totalfound;
            TotalResultFoundLabel.Text = $"{totalfound}/{totalContentCount} Result Found";
            foreach (Content c in found)
            {
                ResultListBox.Items.Add(c.Title);
            }   
        }

        private void ResultListBox_DoubleClick(object sender, EventArgs e)
        {
            selectedContent = found[ResultListBox.SelectedIndex];
            selectedContent.View++;
            updateContentBox();
            if (selectedContent.isLiked(curUser.getUsername()))
            {
                LikeBtn.Text = "Unlike";
            }
            else
            {
                LikeBtn.Text = "Like";
            }
        }

        private void updateContentBox()
        {
            JudulLabel.Text = selectedContent.Title;
            ByLabel.Text = $"By : {selectedContent.Uploader}";
            PostedLabel.Text = $"Posted on : {selectedContent.postDate.ToString()}";
            ViewLabel.Text = $"View : {selectedContent.View.ToString()}";
            LikeLabel.Text = $"Like : {selectedContent.Like.ToString()}";
            textBox3.Text = selectedContent.Isi;
        }

        private void LikeBtn_Click(object sender, EventArgs e)
        {
            if (LikeBtn.Text.Equals("Like"))
            {
                LikeBtn.Text = "Unlike";
                selectedContent.UserLiked(curUser.getUsername());
                updateContentBox();
            }
            else
            {
                LikeBtn.Text = "Like";
                selectedContent.unLike(curUser.getUsername());
                updateContentBox();
            }
        }
    }
}
