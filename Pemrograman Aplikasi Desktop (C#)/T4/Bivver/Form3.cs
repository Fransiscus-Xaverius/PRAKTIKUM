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
    public partial class Form3 : Form
    {
        DataSet1 ds;
        List<Users> listUser;
        List<Jobs> listJobs;
        DataTable dt;
        int RowIndex = -1;

        public Form3()
        {
            InitializeComponent();
        }

        public Form3(DataSet1 ds, List<Users> listUser, List<Jobs> listJobs)
        {
            InitializeComponent();
            this.ds = ds;
            this.listUser = listUser;
            this.listJobs = listJobs;
            dt = ds.Tables["tabelJobs"];
        }


        private void logoutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form1 f1 = new Form1(ds, listUser, listJobs);
            this.Hide();
            f1.Show();
        }

        private void usersToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form2 f2 = new Form2(ds, listUser, listJobs);
            this.Hide();
            f2.Show();
        }

        private void Form3_Load(object sender, EventArgs e)
        {
            updateBtn.Enabled = false;
            deleteBtn.Enabled = false;
            updateData();
        }

        private void updateData(){
            dt.Clear();
            foreach(Jobs job in listJobs){
                DataRow dr = dt.NewRow();
                dr["applicant"] = job.applicant;
                dr["category"] = job.category;
                dr["description"] = job.description;
                dr["price"] = job.harga;
                dr["worker"] = job.worker;
                dt.Rows.Add(dr);
            }
            dataGridView1.DataSource = dt;
            
            //dataGridView1.DataSource = ds.Tables["tabelJobs"];
        }


        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            
        }

        private void dataGridView1_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            if(e.ColumnIndex == 1){
                string x = e.Value.ToString();
                if(x == "Teknologi"){
                    e.CellStyle.ForeColor = Color.Green;
                } else if(x == "Literasi"){
                    e.CellStyle.ForeColor = Color.Red;
                } else if(x == "Desain"){
                    e.CellStyle.ForeColor = Color.Blue;
                }
            }
        }

        private void insertBtn_Click(object sender, EventArgs e)
        {
            if(tbApplicant.Text !="" && cbCategory.SelectedItem.ToString() != "" && priceNud.Value > 0 && tbDesc.Text != "")
            {
                string applicant = tbApplicant.Text;
                string category = cbCategory.SelectedItem.ToString();
                string description = tbDesc.Text;
                int price = (int)priceNud.Value;
                listJobs.Add(new Jobs(applicant, category, description, price));
                updateData();
                hapus();

            } else
            {
                MessageBox.Show("Semua field harus terisi!");
            }
        }

        private void clearBtn_Click(object sender, EventArgs e)
        {
            hapus();
        }

        private void dataGridView1_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            if(e.RowIndex >= 0)
            {
                RowIndex = e.RowIndex;
                tbApplicant.Text = dataGridView1.Rows[e.RowIndex].Cells[0].Value.ToString();
                cbCategory.SelectedItem = dataGridView1.Rows[e.RowIndex].Cells[1].Value.ToString();
                tbDesc.Text = dataGridView1.Rows[e.RowIndex].Cells[2].Value.ToString();
                priceNud.Value = Convert.ToInt32(dataGridView1.Rows[e.RowIndex].Cells[3].Value.ToString());
                updateBtn.Enabled = true;
                deleteBtn.Enabled = true;
                insertBtn.Enabled = false;
            }
        }

        private void hapus(){
            tbApplicant.Text = "";                
            cbCategory.SelectedIndex = -1;
            tbDesc.Text = "";
            priceNud.Value = 0;
        }

        private void updateBtn_Click(object sender, EventArgs e)
        {
            if(RowIndex > -1){
                Console.WriteLine(RowIndex);
                dt.Rows[RowIndex]["applicant"] = tbApplicant.Text;
                dt.Rows[RowIndex]["category"] = cbCategory.SelectedItem.ToString();
                dt.Rows[RowIndex]["description"] = tbDesc.Text;
                dt.Rows[RowIndex]["price"] = priceNud.Value;
                listJobs[RowIndex].applicant = dt.Rows[RowIndex]["applicant"].ToString();
                listJobs[RowIndex].category = dt.Rows[RowIndex]["category"].ToString();
                listJobs[RowIndex].description = dt.Rows[RowIndex]["description"].ToString();
                listJobs[RowIndex].harga = Convert.ToInt32(priceNud.Value);
                updateData();
                hapus();
                RowIndex = -1;
                updateBtn.Enabled = false;
                insertBtn.Enabled = true;
                deleteBtn.Enabled = false;
            }
        }

        private void deleteBtn_Click(object sender, EventArgs e)
        {
            if(RowIndex > -1){
                dt.Rows.RemoveAt(RowIndex);
                listJobs.RemoveAt(RowIndex);
                deleteBtn.Enabled = false;
                updateBtn.Enabled = false;
                insertBtn.Enabled = true;
                hapus();
            }
        }

        private void Form3_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }
    }
}
