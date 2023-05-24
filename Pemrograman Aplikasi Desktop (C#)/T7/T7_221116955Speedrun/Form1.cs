using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySql.Data.MySqlClient;

namespace T7_221116955Speedrun
{
    public partial class Form1 : Form
    {
        MySqlConnection conn;
        DataSet transaksi;
        public Form1()
        {
            InitializeComponent();
            try
            {
                connect();
            }
            catch(Exception e)
            {
                MessageBox.Show("Gagal Connect.");
                Application.Exit();
            }
        }

        public void connect()
        {
            conn = new MySqlConnection("server=localhost;uid=root;database=rubik");
            conn.Open();
            conn.Close();
        }

        public void load()
        {
            string query = "SELECT kode_promo FROM promo";
            comboBox1.Items.Add("Semua");
            comboBox1.SelectedIndex = 0;
            MySqlCommand cmd = new MySqlCommand(query, conn);
            conn.Open();
            MySqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                comboBox1.Items.Add(reader["kode_promo"].ToString());
            }
            conn.Close();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void reportDocument1_InitReport(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            transaksi = new DataSet();
            if (comboBox1.SelectedIndex != 0)
            {

            }
            else
            {
                string query = "SELECT * FROM h_jual";
            }

            //report
            DateTime firstdate = dateTimePicker1.Value;
            DateTime seconddate = dateTimePicker1.Value;
            string kode = comboBox1.SelectedItem.ToString();
            CrystalReport1 report = new CrystalReport1();
            report.SetParameterValue("date1", firstdate);
            report.SetParameterValue("date2", seconddate);
            report.SetParameterValue("param1", kode);
            crystalReportViewer1.ReportSource = report;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            load();
        }
    }
}
