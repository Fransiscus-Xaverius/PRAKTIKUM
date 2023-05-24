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
    public partial class Form4 : Form
    {
        Form1 main;
        MySqlConnection conn;
        MySqlCommand cmd;
        DataTable dt;
        string query;

        public Form4()
        {
            InitializeComponent();
        }

        public Form4(Form1 f)
        {
            InitializeComponent();
            main = f;
            conn = main.conn;
        }

        private void Form4_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }

        private void Form4_Load(object sender, EventArgs e)
        {
            query = "select al.al_id as \"Id\", al.al_name as \"Nama\", i.in_name as \"Instrument\", al.al_price as \"Harga\", b.br_name as \"Brand\", c.co_name as \"Color\" from variant va, alatmusik al, instrument i, brand b, color c where al.al_in_id = i.in_id and b.br_id = al.al_br_id and va.va_al_id = al.al_id and c.co_id = va.va_co_id";
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
            dataGridView1.Columns[5].AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill;
        }

        private void logoutBtn_Click(object sender, EventArgs e)
        {
            main.Show();
            this.Hide();
        }

        private void resetBtn_Click(object sender, EventArgs e)
        {
            ascRb.Checked = false;
            descRb.Checked = false;
            filterTb.Text = "";

            query = "select al.al_id as \"Id\", al.al_name as \"Nama\", i.in_name as \"Instrument\", al.al_price as \"Harga\", b.br_name as \"Brand\", c.co_name as \"Color\" from variant va, alatmusik al, instrument i, brand b, color c where al.al_in_id = i.in_id and b.br_id = al.al_br_id and va.va_al_id = al.al_id and c.co_id = va.va_co_id";
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
            dataGridView1.Columns[5].AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill;
        }

        private void filterTb_TextChanged(object sender, EventArgs e)
        {
            if (filterTb.Text.Length > 0)
            {
                string text = filterTb.Text;
                query = "select al.al_id as \"Id\", al.al_name as \"Nama\", i.in_name as \"Instrument\", al.al_price as \"Harga\", b.br_name as \"Brand\", c.co_name as \"Color\" from variant va, alatmusik al, instrument i, brand b, color c where al.al_in_id = i.in_id and b.br_id = al.al_br_id and va.va_al_id = al.al_id and c.co_id = va.va_co_id and (al.al_name like @text or i.in_name like @text or b.br_name like @text or c.co_name like @text)";
                cmd = new MySqlCommand(query, conn);
                cmd.Parameters.Add(new MySqlParameter("@text", "%" + text + "%"));
                conn.Open();
                cmd.ExecuteReader();
                conn.Close();

                MySqlDataAdapter da = new MySqlDataAdapter(cmd);
                dt = new DataTable();
                da.Fill(dt);
                dataGridView1.DataSource = dt;
            } else
            {
                query = "select al.al_id as \"Id\", al.al_name as \"Nama\", i.in_name as \"Instrument\", al.al_price as \"Harga\", b.br_name as \"Brand\", c.co_name as \"Color\" from variant va, alatmusik al, instrument i, brand b, color c where al.al_in_id = i.in_id and b.br_id = al.al_br_id and va.va_al_id = al.al_id and c.co_id = va.va_co_id";
                cmd = new MySqlCommand(query, conn);
                conn.Open();
                cmd.ExecuteReader();
                conn.Close();
                MySqlDataAdapter da = new MySqlDataAdapter(cmd);
                dt = new DataTable();
                da.Fill(dt);
                dataGridView1.DataSource = dt;
            }
        }

        private void ascRb_CheckedChanged(object sender, EventArgs e)
        {
            if(ascRb.Checked == true)
            {
                string text = filterTb.Text;
                query = "select al.al_id as \"Id\", al.al_name as \"Nama\", i.in_name as \"Instrument\", al.al_price as \"Harga\", b.br_name as \"Brand\", c.co_name as \"Color\" from variant va, alatmusik al, instrument i, brand b, color c where al.al_in_id = i.in_id and b.br_id = al.al_br_id and va.va_al_id = al.al_id and c.co_id = va.va_co_id and (al.al_name like @text or i.in_name like @text or b.br_name like @text or c.co_name like @text) order by al.al_name asc";
                cmd = new MySqlCommand(query, conn);
                cmd.Parameters.Add(new MySqlParameter("@text", "%" + text + "%"));
                conn.Open();
                cmd.ExecuteReader();
                conn.Close();

                MySqlDataAdapter da = new MySqlDataAdapter(cmd);
                dt = new DataTable();
                da.Fill(dt);
                dataGridView1.DataSource = dt;
            }
        }

        private void descRb_CheckedChanged(object sender, EventArgs e)
        {
            if (descRb.Checked == true)
            {
                string text = filterTb.Text;
                query = "select al.al_id as \"Id\", al.al_name as \"Nama\", i.in_name as \"Instrument\", al.al_price as \"Harga\", b.br_name as \"Brand\", c.co_name as \"Color\" from variant va, alatmusik al, instrument i, brand b, color c where al.al_in_id = i.in_id and b.br_id = al.al_br_id and va.va_al_id = al.al_id and c.co_id = va.va_co_id and (al.al_name like @text or i.in_name like @text or b.br_name like @text or c.co_name like @text) order by al.al_name desc";
                cmd = new MySqlCommand(query, conn);
                cmd.Parameters.Add(new MySqlParameter("@text", "%" + text + "%"));
                conn.Open();
                cmd.ExecuteReader();
                conn.Close();

                MySqlDataAdapter da = new MySqlDataAdapter(cmd);
                dt = new DataTable();
                da.Fill(dt);
                dataGridView1.DataSource = dt;
            }
        }
    }
}
