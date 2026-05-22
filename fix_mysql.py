import paramiko
import time

ssh = paramiko.SSHClient()
ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
try:
    print("Attempting to connect...")
    ssh.connect('10.245.232.204', username='adarshjha', password='adarshbgmi27', timeout=10)
    print("Connected to SSH successfully!")
    
    # Try to lower password policy first, then create user
    sql = "SET GLOBAL validate_password.policy=LOW; SET GLOBAL validate_password.length=4; CREATE USER IF NOT EXISTS 'root'@'%' IDENTIFIED BY 'adarshbgmi27'; ALTER USER 'root'@'%' IDENTIFIED BY 'adarshbgmi27'; GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION; FLUSH PRIVILEGES;"
    command = f"sudo -S mysql -u root -padarshbgmi27 -e \"{sql}\""
    
    print("Running MySQL permission command...")
    stdin, stdout, stderr = ssh.exec_command(command)
    stdin.write('adarshbgmi27\n')
    stdin.flush()
    
    out = stdout.read().decode()
    err = stderr.read().decode()
    if out: print("STDOUT:", out)
    if err: print("STDERR:", err)
    
    print("Restarting MySQL service...")
    command2 = "sudo -S systemctl restart mysql"
    stdin, stdout, stderr = ssh.exec_command(command2)
    stdin.write('adarshbgmi27\n')
    stdin.flush()
    
    out2 = stdout.read().decode()
    err2 = stderr.read().decode()
    if out2: print("STDOUT2:", out2)
    if err2: print("STDERR2:", err2)
    
    print("All commands executed on VM.")
except Exception as e:
    print(f"Failed: {e}")
finally:
    ssh.close()
