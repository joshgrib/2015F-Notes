import subprocess
# path to a python interpreter that runs any python script
# under the virtualenv /path/to/virtualenv/
python_bin = "./venv/bin/python"

# path to the script that must run under the virtualenv
script_file = "getData.py"

subprocess.Popen([python_bin, script_file])

