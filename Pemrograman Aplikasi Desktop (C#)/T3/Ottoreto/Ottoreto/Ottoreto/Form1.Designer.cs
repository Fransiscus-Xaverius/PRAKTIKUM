namespace Ottoreto
{
    partial class Form1
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
            this.OttoretoLabel = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.SkorLabel = new System.Windows.Forms.Label();
            this.NameTB = new System.Windows.Forms.TextBox();
            this.LeaderboardGrp = new System.Windows.Forms.GroupBox();
            this.Leaderboard = new System.Windows.Forms.ListBox();
            this.Sequence = new System.Windows.Forms.GroupBox();
            this.StartStopBtn = new System.Windows.Forms.Button();
            this.SubmitBtn = new System.Windows.Forms.Button();
            this.ResetBtn = new System.Windows.Forms.Button();
            this.LeaderboardGrp.SuspendLayout();
            this.SuspendLayout();
            // 
            // OttoretoLabel
            // 
            this.OttoretoLabel.AutoSize = true;
            this.OttoretoLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.OttoretoLabel.Location = new System.Drawing.Point(177, 34);
            this.OttoretoLabel.Name = "OttoretoLabel";
            this.OttoretoLabel.Size = new System.Drawing.Size(97, 25);
            this.OttoretoLabel.TabIndex = 0;
            this.OttoretoLabel.Text = "Ottoreto";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(267, 69);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(35, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Skor :";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(267, 92);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(44, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Name : ";
            // 
            // SkorLabel
            // 
            this.SkorLabel.AutoSize = true;
            this.SkorLabel.Location = new System.Drawing.Point(308, 69);
            this.SkorLabel.Name = "SkorLabel";
            this.SkorLabel.Size = new System.Drawing.Size(0, 13);
            this.SkorLabel.TabIndex = 3;
            // 
            // NameTB
            // 
            this.NameTB.Location = new System.Drawing.Point(311, 89);
            this.NameTB.Name = "NameTB";
            this.NameTB.Size = new System.Drawing.Size(120, 20);
            this.NameTB.TabIndex = 4;
            this.NameTB.TextChanged += new System.EventHandler(this.NameTB_TextChanged);
            // 
            // LeaderboardGrp
            // 
            this.LeaderboardGrp.Controls.Add(this.Leaderboard);
            this.LeaderboardGrp.Location = new System.Drawing.Point(270, 184);
            this.LeaderboardGrp.Name = "LeaderboardGrp";
            this.LeaderboardGrp.Size = new System.Drawing.Size(161, 308);
            this.LeaderboardGrp.TabIndex = 5;
            this.LeaderboardGrp.TabStop = false;
            this.LeaderboardGrp.Text = "Leaderboard";
            // 
            // Leaderboard
            // 
            this.Leaderboard.FormattingEnabled = true;
            this.Leaderboard.Location = new System.Drawing.Point(6, 19);
            this.Leaderboard.Name = "Leaderboard";
            this.Leaderboard.Size = new System.Drawing.Size(149, 277);
            this.Leaderboard.TabIndex = 0;
            // 
            // Sequence
            // 
            this.Sequence.Location = new System.Drawing.Point(11, 510);
            this.Sequence.Name = "Sequence";
            this.Sequence.Size = new System.Drawing.Size(420, 100);
            this.Sequence.TabIndex = 6;
            this.Sequence.TabStop = false;
            this.Sequence.Text = "Sequence";
            // 
            // StartStopBtn
            // 
            this.StartStopBtn.Enabled = false;
            this.StartStopBtn.Location = new System.Drawing.Point(270, 115);
            this.StartStopBtn.Name = "StartStopBtn";
            this.StartStopBtn.Size = new System.Drawing.Size(75, 23);
            this.StartStopBtn.TabIndex = 7;
            this.StartStopBtn.Text = "Start";
            this.StartStopBtn.UseVisualStyleBackColor = true;
            this.StartStopBtn.Click += new System.EventHandler(this.StartStopBtn_Click);
            // 
            // SubmitBtn
            // 
            this.SubmitBtn.Enabled = false;
            this.SubmitBtn.Location = new System.Drawing.Point(270, 144);
            this.SubmitBtn.Name = "SubmitBtn";
            this.SubmitBtn.Size = new System.Drawing.Size(161, 34);
            this.SubmitBtn.TabIndex = 9;
            this.SubmitBtn.Text = "Submit";
            this.SubmitBtn.UseVisualStyleBackColor = true;
            this.SubmitBtn.Click += new System.EventHandler(this.SubmitBtn_Click);
            // 
            // ResetBtn
            // 
            this.ResetBtn.Enabled = false;
            this.ResetBtn.Location = new System.Drawing.Point(356, 115);
            this.ResetBtn.Name = "ResetBtn";
            this.ResetBtn.Size = new System.Drawing.Size(75, 23);
            this.ResetBtn.TabIndex = 10;
            this.ResetBtn.Text = "Reset";
            this.ResetBtn.UseVisualStyleBackColor = true;
            this.ResetBtn.Click += new System.EventHandler(this.ResetBtn_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(444, 638);
            this.Controls.Add(this.ResetBtn);
            this.Controls.Add(this.SubmitBtn);
            this.Controls.Add(this.StartStopBtn);
            this.Controls.Add(this.Sequence);
            this.Controls.Add(this.LeaderboardGrp);
            this.Controls.Add(this.NameTB);
            this.Controls.Add(this.SkorLabel);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.OttoretoLabel);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.LeaderboardGrp.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label OttoretoLabel;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label SkorLabel;
        private System.Windows.Forms.TextBox NameTB;
        private System.Windows.Forms.GroupBox LeaderboardGrp;
        private System.Windows.Forms.ListBox Leaderboard;
        private System.Windows.Forms.GroupBox Sequence;
        private System.Windows.Forms.Button StartStopBtn;
        private System.Windows.Forms.Button SubmitBtn;
        private System.Windows.Forms.Button ResetBtn;
    }
}

