namespace ProgramBlog
{
    partial class Form2
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
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.cToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.browserToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.LoginGroup = new System.Windows.Forms.GroupBox();
            this.LoginBtn = new System.Windows.Forms.Button();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.SearchGroup = new System.Windows.Forms.GroupBox();
            this.SearchBtn = new System.Windows.Forms.Button();
            this.SearchTB = new System.Windows.Forms.TextBox();
            this.ContentGrp = new System.Windows.Forms.GroupBox();
            this.textBox3 = new System.Windows.Forms.TextBox();
            this.LikeBtn = new System.Windows.Forms.Button();
            this.LikeLabel = new System.Windows.Forms.Label();
            this.ViewLabel = new System.Windows.Forms.Label();
            this.PostedLabel = new System.Windows.Forms.Label();
            this.ByLabel = new System.Windows.Forms.Label();
            this.JudulLabel = new System.Windows.Forms.Label();
            this.ResultGroup = new System.Windows.Forms.GroupBox();
            this.progressBar1 = new System.Windows.Forms.ProgressBar();
            this.ResultListBox = new System.Windows.Forms.ListBox();
            this.TotalResultFoundLabel = new System.Windows.Forms.Label();
            this.menuStrip1.SuspendLayout();
            this.LoginGroup.SuspendLayout();
            this.SearchGroup.SuspendLayout();
            this.ContentGrp.SuspendLayout();
            this.ResultGroup.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.cToolStripMenuItem,
            this.browserToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(800, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // cToolStripMenuItem
            // 
            this.cToolStripMenuItem.Name = "cToolStripMenuItem";
            this.cToolStripMenuItem.Size = new System.Drawing.Size(58, 20);
            this.cToolStripMenuItem.Text = "Creator";
            this.cToolStripMenuItem.Click += new System.EventHandler(this.cToolStripMenuItem_Click);
            // 
            // browserToolStripMenuItem
            // 
            this.browserToolStripMenuItem.Name = "browserToolStripMenuItem";
            this.browserToolStripMenuItem.Size = new System.Drawing.Size(61, 20);
            this.browserToolStripMenuItem.Text = "Browser";
            // 
            // LoginGroup
            // 
            this.LoginGroup.Controls.Add(this.LoginBtn);
            this.LoginGroup.Controls.Add(this.textBox2);
            this.LoginGroup.Controls.Add(this.textBox1);
            this.LoginGroup.Controls.Add(this.label2);
            this.LoginGroup.Controls.Add(this.label1);
            this.LoginGroup.Location = new System.Drawing.Point(12, 27);
            this.LoginGroup.Name = "LoginGroup";
            this.LoginGroup.Size = new System.Drawing.Size(360, 88);
            this.LoginGroup.TabIndex = 1;
            this.LoginGroup.TabStop = false;
            this.LoginGroup.Text = "Login";
            // 
            // LoginBtn
            // 
            this.LoginBtn.Location = new System.Drawing.Point(6, 59);
            this.LoginBtn.Name = "LoginBtn";
            this.LoginBtn.Size = new System.Drawing.Size(348, 23);
            this.LoginBtn.TabIndex = 3;
            this.LoginBtn.Text = "Login";
            this.LoginBtn.UseVisualStyleBackColor = true;
            this.LoginBtn.Click += new System.EventHandler(this.LoginBtn_Click);
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(63, 35);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(291, 20);
            this.textBox2.TabIndex = 2;
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(63, 13);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(291, 20);
            this.textBox1.TabIndex = 1;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(4, 16);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(64, 13);
            this.label2.TabIndex = 0;
            this.label2.Text = "Username : ";
            this.label2.Click += new System.EventHandler(this.label2_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(6, 38);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(62, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Password : ";
            // 
            // SearchGroup
            // 
            this.SearchGroup.Controls.Add(this.SearchBtn);
            this.SearchGroup.Controls.Add(this.SearchTB);
            this.SearchGroup.Location = new System.Drawing.Point(12, 121);
            this.SearchGroup.Name = "SearchGroup";
            this.SearchGroup.Size = new System.Drawing.Size(360, 73);
            this.SearchGroup.TabIndex = 2;
            this.SearchGroup.TabStop = false;
            this.SearchGroup.Text = "Search Engine";
            // 
            // SearchBtn
            // 
            this.SearchBtn.Location = new System.Drawing.Point(7, 44);
            this.SearchBtn.Name = "SearchBtn";
            this.SearchBtn.Size = new System.Drawing.Size(348, 23);
            this.SearchBtn.TabIndex = 3;
            this.SearchBtn.Text = "Search";
            this.SearchBtn.UseVisualStyleBackColor = true;
            this.SearchBtn.Click += new System.EventHandler(this.SearchBtn_Click);
            // 
            // SearchTB
            // 
            this.SearchTB.Location = new System.Drawing.Point(9, 19);
            this.SearchTB.Name = "SearchTB";
            this.SearchTB.Size = new System.Drawing.Size(345, 20);
            this.SearchTB.TabIndex = 2;
            // 
            // ContentGrp
            // 
            this.ContentGrp.Controls.Add(this.textBox3);
            this.ContentGrp.Controls.Add(this.LikeBtn);
            this.ContentGrp.Controls.Add(this.LikeLabel);
            this.ContentGrp.Controls.Add(this.ViewLabel);
            this.ContentGrp.Controls.Add(this.PostedLabel);
            this.ContentGrp.Controls.Add(this.ByLabel);
            this.ContentGrp.Controls.Add(this.JudulLabel);
            this.ContentGrp.Location = new System.Drawing.Point(378, 27);
            this.ContentGrp.Name = "ContentGrp";
            this.ContentGrp.Size = new System.Drawing.Size(410, 497);
            this.ContentGrp.TabIndex = 3;
            this.ContentGrp.TabStop = false;
            this.ContentGrp.Text = "Content";
            // 
            // textBox3
            // 
            this.textBox3.Enabled = false;
            this.textBox3.Location = new System.Drawing.Point(13, 138);
            this.textBox3.Multiline = true;
            this.textBox3.Name = "textBox3";
            this.textBox3.Size = new System.Drawing.Size(380, 353);
            this.textBox3.TabIndex = 7;
            // 
            // LikeBtn
            // 
            this.LikeBtn.Location = new System.Drawing.Point(58, 111);
            this.LikeBtn.Name = "LikeBtn";
            this.LikeBtn.Size = new System.Drawing.Size(75, 23);
            this.LikeBtn.TabIndex = 6;
            this.LikeBtn.Text = "Like";
            this.LikeBtn.UseVisualStyleBackColor = true;
            this.LikeBtn.Click += new System.EventHandler(this.LikeBtn_Click);
            // 
            // LikeLabel
            // 
            this.LikeLabel.AutoSize = true;
            this.LikeLabel.Location = new System.Drawing.Point(10, 116);
            this.LikeLabel.Name = "LikeLabel";
            this.LikeLabel.Size = new System.Drawing.Size(42, 13);
            this.LikeLabel.TabIndex = 5;
            this.LikeLabel.Text = "Like : 0";
            // 
            // ViewLabel
            // 
            this.ViewLabel.AutoSize = true;
            this.ViewLabel.Location = new System.Drawing.Point(7, 94);
            this.ViewLabel.Name = "ViewLabel";
            this.ViewLabel.Size = new System.Drawing.Size(45, 13);
            this.ViewLabel.TabIndex = 4;
            this.ViewLabel.Text = "View : 0";
            // 
            // PostedLabel
            // 
            this.PostedLabel.AutoSize = true;
            this.PostedLabel.ForeColor = System.Drawing.SystemColors.ControlLight;
            this.PostedLabel.Location = new System.Drawing.Point(7, 64);
            this.PostedLabel.Name = "PostedLabel";
            this.PostedLabel.Size = new System.Drawing.Size(67, 13);
            this.PostedLabel.TabIndex = 3;
            this.PostedLabel.Text = "Posted on : -";
            // 
            // ByLabel
            // 
            this.ByLabel.AutoSize = true;
            this.ByLabel.ForeColor = System.Drawing.SystemColors.ControlLight;
            this.ByLabel.Location = new System.Drawing.Point(7, 42);
            this.ByLabel.Name = "ByLabel";
            this.ByLabel.Size = new System.Drawing.Size(31, 13);
            this.ByLabel.TabIndex = 1;
            this.ByLabel.Text = "By : -";
            // 
            // JudulLabel
            // 
            this.JudulLabel.AutoSize = true;
            this.JudulLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.JudulLabel.Location = new System.Drawing.Point(6, 16);
            this.JudulLabel.Name = "JudulLabel";
            this.JudulLabel.Size = new System.Drawing.Size(15, 20);
            this.JudulLabel.TabIndex = 0;
            this.JudulLabel.Text = "-";
            // 
            // ResultGroup
            // 
            this.ResultGroup.Controls.Add(this.progressBar1);
            this.ResultGroup.Controls.Add(this.ResultListBox);
            this.ResultGroup.Controls.Add(this.TotalResultFoundLabel);
            this.ResultGroup.Location = new System.Drawing.Point(12, 200);
            this.ResultGroup.Name = "ResultGroup";
            this.ResultGroup.Size = new System.Drawing.Size(360, 324);
            this.ResultGroup.TabIndex = 4;
            this.ResultGroup.TabStop = false;
            this.ResultGroup.Text = "Search Result";
            // 
            // progressBar1
            // 
            this.progressBar1.Location = new System.Drawing.Point(6, 39);
            this.progressBar1.Name = "progressBar1";
            this.progressBar1.Size = new System.Drawing.Size(348, 26);
            this.progressBar1.TabIndex = 3;
            // 
            // ResultListBox
            // 
            this.ResultListBox.FormattingEnabled = true;
            this.ResultListBox.Location = new System.Drawing.Point(6, 78);
            this.ResultListBox.Name = "ResultListBox";
            this.ResultListBox.Size = new System.Drawing.Size(348, 238);
            this.ResultListBox.TabIndex = 2;
            this.ResultListBox.DoubleClick += new System.EventHandler(this.ResultListBox_DoubleClick);
            // 
            // TotalResultFoundLabel
            // 
            this.TotalResultFoundLabel.AutoSize = true;
            this.TotalResultFoundLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TotalResultFoundLabel.Location = new System.Drawing.Point(102, 16);
            this.TotalResultFoundLabel.Name = "TotalResultFoundLabel";
            this.TotalResultFoundLabel.Size = new System.Drawing.Size(157, 20);
            this.TotalResultFoundLabel.TabIndex = 1;
            this.TotalResultFoundLabel.Text = "0/10 Result Found";
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 536);
            this.Controls.Add(this.ResultGroup);
            this.Controls.Add(this.ContentGrp);
            this.Controls.Add(this.SearchGroup);
            this.Controls.Add(this.LoginGroup);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Form2";
            this.Text = "Form2";
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.Form2_FormClosed);
            this.Load += new System.EventHandler(this.Form2_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.LoginGroup.ResumeLayout(false);
            this.LoginGroup.PerformLayout();
            this.SearchGroup.ResumeLayout(false);
            this.SearchGroup.PerformLayout();
            this.ContentGrp.ResumeLayout(false);
            this.ContentGrp.PerformLayout();
            this.ResultGroup.ResumeLayout(false);
            this.ResultGroup.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem cToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem browserToolStripMenuItem;
        private System.Windows.Forms.GroupBox LoginGroup;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button LoginBtn;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.GroupBox SearchGroup;
        private System.Windows.Forms.Button SearchBtn;
        private System.Windows.Forms.TextBox SearchTB;
        private System.Windows.Forms.GroupBox ContentGrp;
        private System.Windows.Forms.TextBox textBox3;
        private System.Windows.Forms.Button LikeBtn;
        private System.Windows.Forms.Label LikeLabel;
        private System.Windows.Forms.Label ViewLabel;
        private System.Windows.Forms.Label PostedLabel;
        private System.Windows.Forms.Label ByLabel;
        private System.Windows.Forms.Label JudulLabel;
        private System.Windows.Forms.GroupBox ResultGroup;
        private System.Windows.Forms.ListBox ResultListBox;
        private System.Windows.Forms.Label TotalResultFoundLabel;
        private System.Windows.Forms.ProgressBar progressBar1;
    }
}