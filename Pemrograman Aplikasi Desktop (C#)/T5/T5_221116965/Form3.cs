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
    public partial class Form3 : Form
    {
        Form1 main;
        MySqlConnection conn;
        MySqlCommand cmd;
        DataTable dt;        
        string query;
        string temp;
        int index = -1;

        public Form3()
        {
            InitializeComponent();
        }

        public Form3(Form1 f)
        {
            InitializeComponent();
            main = f;
            searchCB.SelectedIndex = 0;
            conn = main.conn;
        }

        public Form3(Form1 f, string id, string nama, string harga, string instrument, string brand)
        {
            InitializeComponent();

            main = f;
            searchCB.SelectedIndex = 0;
            conn = main.conn;

            idTb.Text = id;
            namaTb.Text = nama;
            hargaTb.Text = harga;
            instrumentTb.Text = instrument;
            brandTb.Text = brand;
            
            query = "select co_name from color";
            cmd = new MySqlCommand(query, conn);
            conn.Open();
            MySqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                colorCB.Items.Add(reader.GetString(0));
            }
            conn.Close();
        }

        private void Form3_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }

        private void Form3_Load(object sender, EventArgs e)
        {
            insertMode();
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

        void insertMode()
        {
            deleteBtn.Enabled = false;
            updateBtn.Enabled = false;
            idTb.Enabled = false;
            namaTb.Enabled = false;
            hargaTb.Enabled = false;
            instrumentTb.Enabled = false;
            brandTb.Enabled = false;
        }

        void updateMode()
        {
            insertBtn.Enabled = false;
            updateBtn.Enabled = true;
            deleteBtn.Enabled = true;
            colorCB.Enabled = true;
        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void backBtn_Click(object sender, EventArgs e)
        {
            main.Show();
            this.Hide();
        }

        private void searchTB_TextChanged(object sender, EventArgs e)
        {
            //dt.Clear();
            if (searchTB.Text.Length > 0)
            {
                string text = searchTB.Text;
                //Console.WriteLine(text);
                if (searchCB.SelectedItem.Equals(""))
                {

                }
                else if (searchCB.SelectedItem.Equals("Nama"))
                {
                    //Console.WriteLine("search by name");
                    query = "select al.al_id as \"Id\", al.al_name as \"Nama\", i.in_name as \"Instrument\", al.al_price as \"Harga\", b.br_name as \"Brand\", c.co_name as \"Color\" from variant va, alatmusik al, instrument i, brand b, color c where al.al_in_id = i.in_id and b.br_id = al.al_br_id and va.va_al_id = al.al_id and c.co_id = va.va_co_id and al.al_name like @text";
                    cmd = new MySqlCommand(query, conn);
                    cmd.Parameters.Add(new MySqlParameter("@text", "%" + text + "%"));
                }
                else if (searchCB.SelectedItem.Equals("Instrument"))
                {
                    query = "select al.al_id as \"Id\", al.al_name as \"Nama\", i.in_name as \"Instrument\", al.al_price as \"Harga\", b.br_name as \"Brand\", c.co_name as \"Color\" from variant va, alatmusik al, instrument i, brand b, color c where al.al_in_id = i.in_id and b.br_id = al.al_br_id and va.va_al_id = al.al_id and c.co_id = va.va_co_id and i.in_name like @text";
                    cmd = new MySqlCommand(query, conn);
                    cmd.Parameters.Add(new MySqlParameter("@text", "%" + text + "%"));
                }
                else if (searchCB.SelectedItem.Equals("Brand"))
                {
                    query = "select al.al_id as \"Id\", al.al_name as \"Nama\", i.in_name as \"Instrument\", al.al_price as \"Harga\", b.br_name as \"Brand\", c.co_name as \"Color\" from variant va, alatmusik al, instrument i, brand b, color c where al.al_in_id = i.in_id and b.br_id = al.al_br_id and va.va_al_id = al.al_id and c.co_id = va.va_co_id and b.br_name like @text";
                    cmd = new MySqlCommand(query, conn);
                    cmd.Parameters.Add(new MySqlParameter("@text", "%" + text + "%"));
                }
                else if (searchCB.SelectedItem.Equals("Color"))
                {
                    query = "select al.al_id as \"Id\", al.al_name as \"Nama\", i.in_name as \"Instrument\", al.al_price as \"Harga\", b.br_name as \"Brand\", c.co_name as \"Color\" from variant va, alatmusik al, instrument i, brand b, color c where al.al_in_id = i.in_id and b.br_id = al.al_br_id and va.va_al_id = al.al_id and c.co_id = va.va_co_id and c.co_name like @text";
                    cmd = new MySqlCommand(query, conn);
                    cmd.Parameters.Add(new MySqlParameter("@text", "%" + text + "%"));
                }
            } else
            {
                query = "select al.al_id as \"Id\", al.al_name as \"Nama\", i.in_name as \"Instrument\", al.al_price as \"Harga\", b.br_name as \"Brand\", c.co_name as \"Color\" from variant va, alatmusik al, instrument i, brand b, color c where al.al_in_id = i.in_id and b.br_id = al.al_br_id and va.va_al_id = al.al_id and c.co_id = va.va_co_id";
                cmd = new MySqlCommand(query, conn);
            }
            conn.Open();
            cmd.ExecuteReader();
            conn.Close();

            MySqlDataAdapter da = new MySqlDataAdapter(cmd);
            dt = new DataTable();
            da.Fill(dt);
            dataGridView1.DataSource = dt;
        }

        private void searchCB_SelectedIndexChanged(object sender, EventArgs e)
        {
            int idx = searchCB.SelectedIndex;
            string text = searchTB.Text;
            if(idx == 0) //nama
            {
                if (!text.Equals(""))
                {
                    Console.WriteLine("search by name");
                    query = "select al.al_id as \"Id\", al.al_name as \"Nama\", i.in_name as \"Instrument\", al.al_price as \"Harga\", b.br_name as \"Brand\", c.co_name as \"Color\" from variant va, alatmusik al, instrument i, brand b, color c where al.al_in_id = i.in_id and b.br_id = al.al_br_id and va.va_al_id = al.al_id and c.co_id = va.va_co_id and al.al_name like @text";
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
            else if (idx == 1) //instrument
            {
                if (!text.Equals(""))
                {
                    query = "select al.al_id as \"Id\", al.al_name as \"Nama\", i.in_name as \"Instrument\", al.al_price as \"Harga\", b.br_name as \"Brand\", c.co_name as \"Color\" from variant va, alatmusik al, instrument i, brand b, color c where al.al_in_id = i.in_id and b.br_id = al.al_br_id and va.va_al_id = al.al_id and c.co_id = va.va_co_id and i.in_name like @text";
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
            else if (idx == 2)//brand
            {
                if (!text.Equals(""))
                { 
                    query = "select al.al_id as \"Id\", al.al_name as \"Nama\", i.in_name as \"Instrument\", al.al_price as \"Harga\", b.br_name as \"Brand\", c.co_name as \"Color\" from variant va, alatmusik al, instrument i, brand b, color c where al.al_in_id = i.in_id and b.br_id = al.al_br_id and va.va_al_id = al.al_id and c.co_id = va.va_co_id and b.br_name like @text";
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
            else if (idx == 3)//color
            {
                if (!text.Equals(""))
                { 
                    query = "select al.al_id as \"Id\", al.al_name as \"Nama\", i.in_name as \"Instrument\", al.al_price as \"Harga\", b.br_name as \"Brand\", c.co_name as \"Color\" from variant va, alatmusik al, instrument i, brand b, color c where al.al_in_id = i.in_id and b.br_id = al.al_br_id and va.va_al_id = al.al_id and c.co_id = va.va_co_id and c.co_name like @text";
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

        private void hargaTb_TextChanged(object sender, EventArgs e)
        {

        }

        public int getID(){
            int id = 0;
            query = "select va_id from variant order by va_id desc limit 1";
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

        private void chooseBtn_Click(object sender, EventArgs e)
        {
            Form5 f5 = new Form5(main);
            f5.Show();
            this.Hide();
        }

        private void insertBtn_Click(object sender, EventArgs e)
        {
            string id = idTb.Text;
            string color = colorCB.SelectedItem.ToString();
            string temp = getID() + "";
            string vaId = "VA" + temp.PadLeft(3, '0');

            query = "select co_id from color where co_name =  @color";
            cmd = new MySqlCommand(query, conn);
            cmd.Parameters.Add(new MySqlParameter("@color", color));
            conn.Open();
            string colorId = cmd.ExecuteScalar().ToString();
            conn.Close();

            query = "insert into variant values ('"+ vaId + "','"+ id + "','" + colorId + "')";
            cmd = new MySqlCommand(query, conn);
            conn.Open();
            cmd.ExecuteNonQuery();
            conn.Close();
            MessageBox.Show("Data berhasil ditambahkan");
            Form3_Load(sender, e);
            hapus();
        }

        private void updateBtn_Click(object sender, EventArgs e)
        {
            query = "select co_id from color where co_name = @name";
            cmd = new MySqlCommand(query, conn);
            cmd.Parameters.Add(new MySqlParameter("@name", colorCB.SelectedItem.ToString()));
            conn.Open();
            string colorId = cmd.ExecuteScalar().ToString();
            conn.Close();

            query = "update variant set va_co_id = @color where va_al_id = @id and va_co_id = @warnaAwal";
            cmd = new MySqlCommand(query, conn);
            cmd.Parameters.Add(new MySqlParameter("@color", colorId));
            cmd.Parameters.Add(new MySqlParameter("@id", idTb.Text));
            cmd.Parameters.Add(new MySqlParameter("@warnaAwal", temp));
            conn.Open();
            cmd.ExecuteNonQuery();
            conn.Close();
            MessageBox.Show("Data berhasil diupdate");
            Form3_Load(sender, e);      
            hapus();
            insertMode();
        }

        private void deleteBtn_Click(object sender, EventArgs e)
        {
            query = "delete from variant where va_al_id = @id and va_co_id = @warnaAwal";
            cmd = new MySqlCommand(query, conn);
            cmd.Parameters.Add(new MySqlParameter("@id", idTb.Text));
            cmd.Parameters.Add(new MySqlParameter("@warnaAwal", temp));
            conn.Open();
            cmd.ExecuteNonQuery();
            conn.Close();
            MessageBox.Show("Data berhasil dihapus");
            Form3_Load(sender, e);
            hapus();
            insertMode();
        }

        private void dataGridView1_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            index = e.RowIndex;
            idTb.Text = dt.Rows[index]["Id"].ToString();
            namaTb.Text = dt.Rows[index]["Nama"].ToString();
            hargaTb.Text = dt.Rows[index]["Harga"].ToString();
            instrumentTb.Text = dt.Rows[index]["Instrument"].ToString();
            brandTb.Text = dt.Rows[index]["Brand"].ToString();
            
            query = "select co_name from color";
            cmd = new MySqlCommand(query, conn);
            conn.Open();
            MySqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                colorCB.Items.Add(reader.GetString(0));
            }
            conn.Close();
            colorCB.SelectedItem = dt.Rows[index]["Color"].ToString();
            updateMode();
            
            temp = dt.Rows[index]["Color"].ToString();
            query = "select co_id from color where co_name = @name";
            cmd = new MySqlCommand(query, conn);
            cmd.Parameters.Add(new MySqlParameter("@name", temp));
            conn.Open();
            temp = cmd.ExecuteScalar().ToString();
            conn.Close();
        }

        private void clearBtn_Click(object sender, EventArgs e)
        {
            hapus();
        }

        void hapus(){
            idTb.Text = "";
            namaTb.Text = "";
            hargaTb.Text = "";
            brandTb.Text = "";
            instrumentTb.Text = "";
            colorCB.SelectedIndex = -1;
            colorCB.Items.Clear();

            searchTB.Text = "";
            searchCB.SelectedIndex = 0;
        }
    }
}
