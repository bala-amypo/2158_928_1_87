import os

def cleanup_root():
    # Get all files in the current directory
    files = [f for f in os.listdir('.') if os.path.isfile(f)]
    
    deleted_count = 0
    
    for filename in files:
        # We only want to delete files that were likely created by the script error.
        # These are typically files that:
        # 1. Are Java files in the root (where they shouldn't be)
        # 2. Contain backslashes in their name (common artifact of Windows paths on Linux)
        if filename.endswith(".java") or "\\" in filename:
            try:
                os.remove(filename)
                print(f"Deleted: {filename}")
                deleted_count += 1
            except Exception as e:
                print(f"Error deleting {filename}: {e}")

    if deleted_count == 0:
        print("No stray Java files or backslash-named files found in the root directory.")
    else:
        print(f"\nCleanup complete. Deleted {deleted_count} files.")

if __name__ == "__main__":
    cleanup_root()
