
namespace T5_221116965
{
    partial class Form4
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.resetBtn = new System.Windows.Forms.Button();
            this.filterTb = new System.Windows.Forms.TextBox();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.label2 = new System.Windows.Forms.Label();
            this.ascRb = new System.Windows.Forms.RadioButton();
            this.descRb = new System.Windows.Forms.RadioButton();
            this.logoutBtn = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(38, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Filter : ";
            // 
            // resetBtn
            // 
            this.resetBtn.Location = new System.Drawing.Point(525, 4);
            this.resetBtn.Name = "resetBtn";
            this.resetBtn.Size = new System.Drawing.Size(75, 23);
            this.resetBtn.TabIndex = 1;
            this.resetBtn.Text = "Reset";
            this.resetBtn.UseVisualStyleBackColor = true;
            this.resetBtn.Click += new System.EventHandler(this.resetBtn_Click);
            // 
            // filterTb
            // 
            this.filterTb.Location = new System.Drawing.Point(47, 6);
            this.filterTb.Name = "filterTb";
            this.filterTb.Size = new System.Drawing.Size(197, 20);
            this.filterTb.TabIndex = 2;
            this.filterTb.TextChanged += new System.EventHandler(this.filterTb_TextChanged);
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(14, 35);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(666, 403);
            this.dataGridView1.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(260, 9);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(35, 13);
            this.label2.TabIndex = 0;
            this.label2.Text = "Sort : ";
            // 
            // ascRb
            // 
            this.ascRb.AutoSize = true;
            this.ascRb.Location = new System.Drawing.Point(301, 7);
            this.ascRb.Name = "ascRb";
            this.ascRb.Size = new System.Drawing.Size(75, 17);
            this.ascRb.TabIndex = 4;
            this.ascRb.TabStop = true;
            this.ascRb.Text = "Ascending";
            this.ascRb.UseVisualStyleBackColor = true;
            this.ascRb.CheckedChanged += new System.EventHandler(this.ascRb_CheckedChanged);
            // 
            // descRb
            // 
            this.descRb.AutoSize = true;
            this.descRb.Location = new System.Drawing.Point(382, 7);
            this.descRb.Name = "descRb";
            this.descRb.Size = new System.Drawing.Size(82, 17);
            this.descRb.TabIndex = 4;
            this.descRb.TabStop = true;
            this.descRb.Text = "Descending";
            this.descRb.UseVisualStyleBackColor = true;
            this.descRb.CheckedChanged += new System.EventHandler(this.descRb_CheckedChanged);
            // 
            // logoutBtn
            // 
            this.logoutBtn.Location = new System.Drawing.Point(606, 4);
            this.logoutBtn.Name = "logoutBtn";
            this.logoutBtn.Size = new System.Drawing.Size(75, 23);
            this.logoutBtn.TabIndex = 1;
            this.logoutBtn.Text = "Logout";
            this.logoutBtn.UseVisualStyleBackColor = true;
            this.logoutBtn.Click += new System.EventHandler(this.logoutBtn_Click);
            // 
            // Form4
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(689, 450);
            this.Controls.Add(this.descRb);
            this.Controls.Add(this.ascRb);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.filterTb);
            this.Controls.Add(this.logoutBtn);
            this.Controls.Add(this.resetBtn);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "Form4";
            this.Text = "CustomerHome";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form4_FormClosing);
            this.Load += new System.EventHandler(this.Form4_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button resetBtn;
        private System.Windows.Forms.TextBox filterTb;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.RadioButton ascRb;
        private System.Windows.Forms.RadioButton descRb;
        private System.Windows.Forms.Button logoutBtn;
    }
}