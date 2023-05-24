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

namespace T5_221116965
{
    public partial class Form5 : Form
    {
        Form1 main;
        MySqlConnection conn;
        MySqlCommand cmd;
        DataTable dt;
        string query;

        public Form5()
        {
            InitializeComponent();
        }

        public Form5(Form1 f)
        {
            InitializeComponent();
            main = f;
            conn = main.conn;
        }

        private void Form5_FormClosing(object sender, FormClosingEventArgs e)
        {
            Form3 f3 = new Form3(main);
            f3.Show();
            this.Hide();
            // Application.Exit();
        }

        private void Form5_Load(object sender, EventArgs e)
        {
            query = "select al.al_id as \"Id\", al.al_name as \"Nama\", i.in_name as \"Instrument\", al.al_price as \"Harga\", b.br_name as \"Brand\" from alatmusik al, instrument i, brand b where al.al_in_id = i.in_id and b.br_id = al.al_br_id";
            cmd = new MySqlCommand(query, conn);
            conn.Open();
            cmd.ExecuteReader();
            conn.Close();

            MySqlDataAdapter da = new MySqlDataAdapter(cmd);
            dt = new DataTable();
            da.Fill(dt);
            dataGridView1.DataSource = dt;
            dataGridView1.Columns[0].AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill;
            dataGridView1.Columns[1].AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill;
            dataGridView1.Columns[2].AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill;
            dataGridView1.Columns[3].AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill;
            dataGridView1.Columns[4].AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill;
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void dataGridView1_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            int target = e.RowIndex;
            string id = dt.Rows[target]["Id"].ToString();
            string nama = dt.Rows[target]["Nama"].ToString();
            string price = dt.Rows[target]["Harga"].ToString();
            string instrument = dt.Rows[target]["Instrument"].ToString();
            string brand = dt.Rows[target]["Brand"].ToString();
            // MessageBox.Show("Test");
            Form3 f3 = new Form3(main, id, nama, price, instrument, brand);
            f3.Show();
            this.Hide();
        }
    }
}
