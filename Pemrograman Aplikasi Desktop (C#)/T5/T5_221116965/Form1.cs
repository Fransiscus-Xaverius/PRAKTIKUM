using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net.NetworkInformation;
using System.Text;
using System.Threading.Tasks;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySql.Data.MySqlClient;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.ProgressBar;

namespace T5_221116965
{
    public partial class Form1 : Form
    {
        public MySqlConnection conn;
        MySqlCommand cmd;
        DataTable dt;
        string username;
        string password; 
        string query;
        string adaUser;
        public Form1()
        {
            InitializeComponent();
            cekkoneksi();
            cmd = new MySqlCommand();
        }

        public void cekkoneksi()
        {
            conn = new MySqlConnection("server = localhost; uid = root; database = db_toko_alat_musik");
            try
            {
                if (conn.State == ConnectionState.Closed)
                {
                    conn.Open();
                }
                MessageBox.Show("Berhasil Connect DB");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                MessageBox.Show("Gagal Connect DB");

            }
            conn.Close();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            masterColorBtn.Visible = false;
            masterVarBtn.Visible = false;
            logoutBtn.Visible = false;
            helloLbl.Visible = false;
        }

        private void loginBtn_Click(object sender, EventArgs e)
        {
            username = tbUsername.Text;
            password = tbPassword.Text;

            if(username == "" || password == "")
            {
                MessageBox.Show("Semua field harus terisi");
            } 
            else
            {
                adaUser = "";
                query = "select count(*) from users where us_username = @username";
                cmd = new MySqlCommand(query, conn);
                cmd.Parameters.Add(new MySqlParameter("@username", username));
                conn.Open();
                adaUser = cmd.ExecuteScalar().ToString();
                conn.Close();

                if (Convert.ToInt32(adaUser) > 0)
                {
                    query = "select us_password from users where us_username = @username";
                    cmd = new MySqlCommand(query, conn);
                    cmd.Parameters.Add(new MySqlParameter("@username", username));
                    conn.Open();
                    string passBener = cmd.ExecuteScalar().ToString();
                    conn.Close();
                    if (passBener.Equals(password))
                    {
                        query = "select us_priv from users where us_username = @username";
                        cmd = new MySqlCommand(query, conn);
                        cmd.Parameters.Add(new MySqlParameter("@username", username));
                        conn.Open();
                        string hasil = cmd.ExecuteScalar().ToString();
                        conn.Close();

                        if (hasil == "0")
                        {
                            // MessageBox.Show("INI CUSTOMER");
                            Form4 f4 = new Form4(this);
                            f4.Show();
                            this.Hide();
                        }
                        else if (hasil == "1")
                        {
                            query = "select us_name from users where us_username = @username";
                            cmd = new MySqlCommand(query, conn);
                            cmd.Parameters.Add(new MySqlParameter("@username", username));
                            conn.Open();
                            string nama = cmd.ExecuteScalar().ToString();
                            conn.Close();

                            // MessageBox.Show("INI EMPLOYEE");
                            helloLbl.Text = $"Hello, {nama}";
                            masterColorBtn.Visible = true;
                            masterVarBtn.Visible = true;
                            helloLbl.Visible = true;
                            logoutBtn.Visible = true;
                            loginBtn.Visible = false;
                            tbUsername.Visible = false;
                            tbPassword.Visible = false;
                            label1.Visible = false;
                            label2.Visible = false;
                            label3.Visible = false;
                        }

                        tbUsername.Text = "";
                        tbPassword.Text = "";
                    }
                    else
                    {
                        MessageBox.Show("Password Salah");
                        tbPassword.Text = "";
                    }
                }
                else
                {
                    MessageBox.Show("Username tidak ditemukan");
                    tbUsername.Text = "";
                    tbPassword.Text = "";
                }
            }
        }

        private void logoutBtn_Click(object sender, EventArgs e)
        {
            masterColorBtn.Visible = false;
            masterVarBtn.Visible = false;
            logoutBtn.Visible = false;
            helloLbl.Visible = false;
            label1.Visible = true;
            label2.Visible = true;
            label3.Visible = true;
            loginBtn.Visible = true;
            tbUsername.Visible = true;
            tbPassword.Visible = true;
            tbUsername.Text = "";
            tbPassword.Text = "";
        }

        private void masterVarBtn_Click(object sender, EventArgs e)
        {
            Form3 f3 = new Form3(this);
            f3.Show();
            this.Hide();
        }

        private void masterColorBtn_Click(object sender, EventArgs e)
        {
            Form2 f2 = new Form2(this);
            f2.Show();
            this.Hide();
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }
    }
}
