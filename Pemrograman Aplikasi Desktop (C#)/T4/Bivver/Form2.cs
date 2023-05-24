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
    public partial class Form2 : Form
    {
        DataSet1 ds;
        List<Users> listUser;
        List<Jobs> listJobs;
        DataTable dt;
        int RowIndex = -1;

        public Form2()
        {
            InitializeComponent();
        }

        public Form2(DataSet1 ds, List<Users> listUser, List<Jobs> listJobs){
            InitializeComponent();
            this.ds = ds;
            dt = ds.Tables["tabelUsers"];
            this.listUser = listUser;
            this.listJobs = listJobs;
        }

        private void usersToolStripMenuItem_Click(object sender, EventArgs e)
        {
            
        }

        private void jobsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form3 f3 = new Form3(ds, listUser, listJobs);
            this.Hide();
            f3.Show();
        }

        private void logoutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form1 f1 = new Form1(ds, listUser, listJobs);
            this.Hide();
            f1.Show();
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            deleteBtn.Enabled = false;   
            updateData();
        }

        private string reverse(string temp){
            string hasil = "";
            for(int i = temp.Length - 1; i >= 0; i--){
                hasil += temp[i];
            }
            return hasil;
        }

        private void insertBtn_Click(object sender, EventArgs e)
        {
            if(tbUsername.Text != "" && tbNama.Text != ""){
                string username = tbUsername.Text;
                string pass = reverse(tbUsername.Text)+""+tbUsername.Text.Length;
                string passW = pass.ToLower();
                string nama = tbNama.Text;
                int id;
                if(listUser.Count > 0){
                    id = (listUser[listUser.Count - 1].id) + 1;    
                } else {
                    id = 1;
                }
                listUser.Add(new Users(id, username, nama, passW));
                updateData();
                tbUsername.Text = "";
                tbNama.Text = "";
            } else {
                MessageBox.Show("Username dan Nama tidak boleh kosong");
            }
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if(e.RowIndex >= 0){
                RowIndex = e.RowIndex;
                DataGridViewRow row = this.dataGridView1.Rows[e.RowIndex];
                tbUsername.Text = row.Cells[2].Value.ToString();
                tbNama.Text = row.Cells[1].Value.ToString();
                deleteBtn.Enabled = true;
            }
        }

        private void dataGridView1_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            if(e.ColumnIndex == 3){
                string x = e.Value.ToString();
                if(x == "Standby"){
                    e.CellStyle.ForeColor = Color.Green;
                } else if(x == "Working"){
                    e.CellStyle.ForeColor = Color.Red;
                }
            }
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void menuStrip1_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void updateData(){
            dt.Clear();
            foreach(Users user in listUser){
                DataRow dr = dt.NewRow();
                dr["id"] = user.id;
                dr["nama"] = user.nama;
                dr["username"] = user.username;
                dr["status"] = user.status;
                dt.Rows.Add(dr);
            }
            dataGridView1.DataSource = dt;
        }

        private void tbUsername_TextChanged(object sender, EventArgs e)
        {
            if(tbUsername.Text.Length > 0){
                string temp = tbUsername.Text;
                bool adaAngka = false;
                foreach(char c in temp){
                    if(c >= '0' && c <= '9'){
                        adaAngka = true;
                        break;
                    }
                }
                if (adaAngka)
                {
                    MessageBox.Show("Username tidak boleh mengandung angka");
                    tbUsername.Text = "";
                } 
                else 
                {
                    if(temp.Contains(" "))
                    {
                        MessageBox.Show("Username tidak boleh ada spasi");
                        tbUsername.Text = "";
                    }
                }
            }
            
        }

        private void tbNama_TextChanged(object sender, EventArgs e)
        {

        }

        private void deleteBtn_Click(object sender, EventArgs e)
        {
            if(RowIndex > -1){
                dt.Rows.RemoveAt(RowIndex);
                listUser.RemoveAt(RowIndex);
                RowIndex = -1;
                deleteBtn.Enabled = false;
                tbUsername.Text = "";
                tbNama.Text = "";
            }
        }

        private void Form2_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }
    }
}
