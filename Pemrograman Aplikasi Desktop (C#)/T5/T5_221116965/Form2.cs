using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Drawing;
using System.ComponentModel;

namespace T5_221116965
{
    public partial class Form2 : Form
    {
        Form1 main;
        MySqlConnection conn;
        MySqlCommand cmd;
        DataTable dt;
        string query;
        string hexC;
        int target;

        public Form2()
        {
            InitializeComponent();
        }
        
        public Form2(Form1 f)
        {
            InitializeComponent();
            main = f;
            warnaLbl.Text = "";
            hexC = "";
            deleteBtn.Enabled = false;
            target = -1;
        }

        private void Form2_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }

        private void backBtn_Click(object sender, EventArgs e)
        {
            main.Show();
            this.Hide();
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            conn = main.conn;
            query = "select co_id, co_name, co_hex from color";
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
        }

        private void warnaBtn_Click(object sender, EventArgs e)
        {
            ColorDialog cd = new ColorDialog();
            cd.ShowDialog();
            warnaBtn.BackColor = cd.Color;
            Color warna = cd.Color;
            hexC = warna.R.ToString("X2") + warna.G.ToString("X2") + warna.B.ToString("X2");
            warnaLbl.Text = "#" + hexC.ToString();
        }

        private void insertBtn_Click(object sender, EventArgs e)
        {
            string nama = namaTb.Text;
            Color warna = warnaBtn.BackColor;
            if(nama.Equals("") || warna == SystemColors.Control)
            {
                MessageBox.Show("Semua Field harus terisi");
            } 
            else 
            {
                string temp = getID() + "";
                string id = "CO" + temp.PadLeft(3, '0');
                hexC = warna.R.ToString("X2") + warna.G.ToString("X2") + warna.B.ToString("X2");
                query = "insert into color values ('" + id + "', '" + nama + "', '" + hexC + "')";
                cmd = new MySqlCommand(query, conn);
                conn.Open();
                cmd.ExecuteNonQuery();
                conn.Close();
                MessageBox.Show("Data berhasil ditambahkan");
                Form2_Load(sender, e);
                namaTb.Text = "";
                warnaBtn.BackColor = SystemColors.Control;
            }
        }

        public int getID(){
            int id = 0;
            query = "select co_id from color order by co_id desc limit 1";
            cmd = new MySqlCommand(query, conn);
            conn.Open();
            MySqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                id = Int32.Parse(reader.GetString(0).Substring(2));
            }
            conn.Close();
            return id + 1;
        }

        private void dataGridView1_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            deleteBtn.Enabled = true;
            target = e.RowIndex;
            namaTb.Text = dt.Rows[target]["co_name"].ToString();
            warnaBtn.BackColor = ColorTranslator.FromHtml("#" + dt.Rows[target]["co_hex"].ToString());
        }

        private void deleteBtn_Click(object sender, EventArgs e)
        {
            query = "delete from color where co_id = '" + dt.Rows[target]["co_id"].ToString() + "'";
            cmd = new MySqlCommand(query, conn);
            conn.Open();
            cmd.ExecuteNonQuery();
            conn.Close();
            MessageBox.Show("Data berhasil dihapus");
            Form2_Load(sender, e);
        }
    }
}
