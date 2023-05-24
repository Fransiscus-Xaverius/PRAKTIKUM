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
    public partial class Form4 : Form
    {
        DataSet1 ds;
        List<Users> listUser;
        List<Jobs> listJobs;
        DataTable dt;
        DataTable dt2;
        int idxUser;
        int RowIndex = -1;

        public Form4()
        {
            InitializeComponent();
        }
        
        public Form4(DataSet1 ds, List<Users> listUser,int idx, List<Jobs> listJobs)
        {
            InitializeComponent();
            this.ds = ds;
            this.idxUser = idx;
            this.listUser = listUser;
            this.listJobs = listJobs;
            dataGridView1.Visible = false;
            dt = ds.Tables["tabelUserJobs"];
            dt2 = ds.Tables["tabelJobs"];
        }

        private void updateData()
        {
            dt.Clear();
            foreach(Jobs job in listJobs){
                DataRow dr = dt.NewRow();
                dr["applicant"] = job.applicant;
                dr["category"] = job.category;
                dr["description"] = job.description;
                dr["price"] = job.harga;
                dr["status"] = job.status;
                dt.Rows.Add(dr);
            }
            dataGridView1.DataSource = dt;
        }

        private void Form4_Load(object sender, EventArgs e)
        {
            string namaUser = listUser[idxUser].nama;
            labelWelcome.Text = "Welcome, " + namaUser;
            saldoLbl.Text = listUser[idxUser].saldo.ToString();
            jobSkrgLbl.Text = listUser[idxUser].currJobs;
            if (jobSkrgLbl.Text == "-"){
                dataGridView1.Visible = true;
                updateData();
            }
        }

        private void logoutBtn_Click(object sender, EventArgs e)
        {
            Form1 f1 = new Form1(ds, listUser, listJobs);
            this.Hide();
            f1.Show();
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

            if(e.ColumnIndex == 4){
                string x = e.Value.ToString();
                if(x == "Dikerjakan"){
                    e.CellStyle.BackColor = Color.Salmon;
                } else if(x == "Menunggu"){
                    e.CellStyle.BackColor = Color.LimeGreen;
                } else if(x == "Sudah Selesai"){
                    e.CellStyle.BackColor = Color.Yellow;
                }
            }
        }

        private void dataGridView1_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            if(e.RowIndex >= 0)
            {
                RowIndex = e.RowIndex;
                if(dt.Rows[RowIndex]["status"].ToString() == "Menunggu"){
                    jobSkrgLbl.Text = dt.Rows[RowIndex]["description"].ToString();
                    dt.Rows[RowIndex]["status"] = "Dikerjakan";
                    listJobs[RowIndex].status = "Dikerjakan";
                    dt2.Rows[RowIndex]["worker"] = listUser[idxUser].nama;
                    listJobs[RowIndex].worker = listUser[idxUser].nama;
                    listUser[idxUser].currJobs = dt.Rows[RowIndex]["description"].ToString();
                    dataGridView1.Visible = false;
                }
            }
        }

        private void Form4_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }

        private void doneBtn_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < listJobs.Count; i++)
            {
                if (jobSkrgLbl.Text == listJobs[i].description)
                {
                    RowIndex = i;
                }
            }
            
            if(RowIndex > -1)
            {
                if (jobSkrgLbl.Text != "-")
                {
                    dt.Rows[RowIndex]["status"] = "Sudah Selesai";
                    listJobs[RowIndex].status = "Sudah Selesai";
                    int saldo = Convert.ToInt32(dt.Rows[RowIndex]["price"]);
                    listUser[idxUser].saldo += saldo;
                    saldoLbl.Text = listUser[idxUser].saldo.ToString();
                    dataGridView1.Visible = true;
                    listUser[idxUser].currJobs = "-";
                    jobSkrgLbl.Text = "-";
                    RowIndex = -1;
                }
            }
        }
    }
}
