using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Bivver
{
    public partial class Form1 : Form
    {
        
        DataSet1 ds;
        List<Users> listUser;
        List<Jobs> listJobs;
        DataTable dt;
        
        public Form1()
        {
            InitializeComponent();
            ds = new DataSet1();
            listUser = new List<Users>();
            listJobs = new List<Jobs>();
        }

        public Form1(DataSet1 ds, List<Users> listUser, List<Jobs> listJobs)
        {
            InitializeComponent();
            this.ds = ds;
            dt = ds.Tables["tabelUsers"];
            this.listUser = listUser;
            this.listJobs = listJobs;
        }

        private void clear(){
            tbUsername.Text = "";
            tbPassword.Text = "";
        }

        private void clearBtn_Click(object sender, EventArgs e)
        {
            clear();
        }

        private void loginBtn_Click(object sender, EventArgs e)
        {
            if (tbUsername.Text == "admin" && tbPassword.Text == "admin"){
                Form3 f3 = new Form3(ds, listUser, listJobs);
                this.Hide();
                f3.Show();
                clear();
            }
            else{
                int idx = -1;
                if(listUser.Count > 0){
                    for(int i = 0; i < listUser.Count; i++){
                        if(listUser[i].username == tbUsername.Text){
                            idx = i;
                        }
                    }
                    if (idx != -1){
                        if(listUser[idx].password == tbPassword.Text){
                            Form4 f4 = new Form4(ds, listUser, idx, listJobs);
                            this.Hide();
                            f4.Show();
                            clear();
                        }
                        else{
                            MessageBox.Show("Password tidak sesuai");
                            tbPassword.Text = "";
                        }
                    } else {
                        MessageBox.Show("Username tidak ditemukan");
                        tbUsername.Text = "";
                        tbPassword.Text = "";
                    }
                }
                // f4.ShowDialog();
                // this.Show();
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
          
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }
    }
}
