import os
import time
from datetime import datetime

# Configuration
REPO_PATH = 'C:\\Users\\alies\\OneDrive\\Desktop\\py'  # Local path to your repository
README_FILE = os.path.join(REPO_PATH, 'README.md')
COMMIT_MESSAGE = 'Auto-update README'
REMOTE_NAME = 'origin'  # Remote name for your GitHub repository

def create_readme_if_not_exists():
    if not os.path.exists(README_FILE):
        with open(README_FILE, 'w') as file:
            file.write('# README\n\nInitial commit\n')

def update_readme():
    with open(README_FILE, 'a') as file:
        file.write(f'\n- Update at {datetime.now()}')

def commit_and_push():
    os.system(f'cd {REPO_PATH} && git add .')
    os.system(f'cd {REPO_PATH} && git commit -m "{COMMIT_MESSAGE}"')
    os.system(f'cd {REPO_PATH} && git push {REMOTE_NAME} master')

def main():
    commit_count = 0
    while commit_count < 20:
        create_readme_if_not_exists()
        update_readme()
        commit_and_push()
        commit_count += 1
        time.sleep(10)  # Sleep for 10 minutes

if __name__ == '__main__':
    main()



