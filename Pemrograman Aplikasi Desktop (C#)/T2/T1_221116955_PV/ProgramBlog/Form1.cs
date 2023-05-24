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
    public partial class Form1 : Form
    {

        List<User> listuser;
        private User curUser;
        private List<Content> curUserContent;
        private Content curContent;
        DateTime now = DateTime.Now;
        public Form1()
        {
            InitializeComponent();
            UserGroup.Enabled = false;
            ContentMakerGrp.Enabled = false;
            listuser = new List<User>();
        }

        public Form1(List<User> l)
        {
            InitializeComponent();
            this.listuser = l; 
            UserGroup.Enabled = false;
            ContentMakerGrp.Enabled = false;
        }

        private void groupBox3_Enter(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void VisitLabel_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void RegisterBtn_Click(object sender, EventArgs e)
        {
            string newUsername = UsernameTB.Text;
            bool exist = false;
            foreach (User u in listuser)
            {
                if (u.getUsername().Equals(newUsername))
                {
                    exist = true;
                    break;
                }
            }
            if (exist)
            {
                MessageBox.Show("Username harus unik! (Username tersebut sudah terdaftar!)");
            }
            else
            {
                if(PasswordTB.Text.Length > 0&&UsernameTB.Text.Length > 0)
                {
                    string newPassword = PasswordTB.Text;
                    User newUser = new User(newUsername, newPassword);
                    listuser.Add(newUser);
                    MessageBox.Show($"Berhasil mendaftarkan {newUsername}");
                    
                }
                else
                {
                    MessageBox.Show("Harap isi semua field yang ada!");
                }
            }
        }

        private void LoginBtn_Click(object sender, EventArgs e)
        {
            string Username = UsernameTB.Text;
            string Password = PasswordTB.Text;
            bool credentials = false;
            foreach (User u in listuser)
            {
                if (u.getUsername().Equals(Username) && u.getPassword().Equals(Password))
                {
                    credentials = true;
                    curUser = u;
                    break;
                }
            }
            if (credentials)
            {
                if(curUser != null) //useless tapi daripada ngebug sampe tewas...
                {
                    MessageBox.Show($"Selamat datang, {curUser.getUsername()}");
                    LoginRegGroup.Enabled = false;
                    ContentMakerGrp.Enabled = true;
                    UserGroup.Enabled = true;
                    HiLabel.Text = $"Hi, {curUser.getUsername()}";
                    UsernameTB.Text = "";
                    PasswordTB.Text = "";
                    curUserContent = curUser.getContent();
                    ContentCountLabel.Text = $"Content Count : {curUserContent.Count}";
                    updateContentList();
                }
            }
            else
            {
                MessageBox.Show("Username/Password tidak sesuai!");
            }
        }

        private void updateContentList() {
            ContentListBox.Items.Clear();
            foreach (Content c in curUserContent)
            {
                ContentListBox.Items.Add(c.Title);
            }
        }

        private void Logout_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Logging out...");
            curUser = null;
            HiLabel.Text = "Hi, -";
            UserGroup.Enabled = false;
            ContentMakerGrp.Enabled = false;
            ContentListBox.Items.Clear();
            LoginRegGroup.Enabled = true;
            curUserContent = null;
        }

        private void creatorToolStripMenuItem_Click(object sender, EventArgs e)
        {
                
            
        }

        private void browserToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Hide();
            Form2 Browser = new Form2(listuser);
            Browser.Show();   
        }

        private void ContentListBox_DoubleClick(object sender, EventArgs e)
        {
            if(curUserContent!= null)
            {
                curContent = curUserContent[ContentListBox.SelectedIndex];
                ContentTitleTB.Text = curContent.Title;
                richTextBox1.Text = curContent.Isi;
                PostDate.Value = curContent.postDate;
                ContentVisitLabel.Text = $"Visit : {curContent.View}";
                ContentLikeLabel.Text = $"Like : {curContent.Like}";
            }
        }

        private void Reset()
        {
            ContentTitleTB.Text = "";
            richTextBox1.Text = "";
            PostDate.Value = now;
        }

        private void CreateBtn_Click(object sender, EventArgs e)
        {
            if (ContentTitleTB.Text.Length > 0 && PostDate.Value != null&&richTextBox1.Text.Length>0)
            {
                curContent = new Content(ContentTitleTB.Text, curUser.getUsername(), richTextBox1.Text, PostDate.Value);
                curUserContent.Add(curContent);
                ContentCountLabel.Text = $"Content Count : {curUserContent.Count}";
                updateContentList();
                Reset();
            }
            else
            {
                MessageBox.Show("Semua Field harus diisi!");
            }
        }

        private void ResetBtn_Click(object sender, EventArgs e)
        {
            if (curContent == null)
            {
                Reset();
            }
            else
            {
                ContentTitleTB.Text = curContent.Title;
                richTextBox1.Text = curContent.Isi;
                PostDate.Value = curContent.postDate;
            }
        }

        private void DeleteBtn_Click(object sender, EventArgs e)
        {
            curUserContent.RemoveAt(ContentListBox.SelectedIndex);
            ContentCountLabel.Text = $"Content Count : {curUserContent.Count}"; 
            updateContentList();
            curContent = null;
        }

        private void UpdateBtn_Click(object sender, EventArgs e)
        {
            curContent.Title = ContentTitleTB.Text;
            curContent.Isi = richTextBox1.Text;
            curContent.postDate = PostDate.Value;
            Reset();
            curContent = null;
            MessageBox.Show("Updated Content!");
        }

        private void SelectTitleBtn_Click(object sender, EventArgs e)
        {
            ContentTitleTB.Text = richTextBox1.SelectedText;
        }

        private void Form1_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }

        private void ContentVisitLabel_Click(object sender, EventArgs e)
        {

        }

        private void ContentListBox_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}
