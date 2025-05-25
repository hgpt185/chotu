# GitHub Setup Guide

Follow these steps to push your URL Shortener project to GitHub:

## 1. Create a New Repository on GitHub

1. Go to [GitHub](https://github.com) and sign in
2. Click the "+" icon in the top right corner
3. Select "New repository"
4. Name your repository (e.g., `url-shortener-spring-boot`)
5. Add a description: "A URL shortener service built with Spring Boot for learning purposes"
6. Choose "Public" or "Private"
7. **DO NOT** initialize with README, .gitignore, or license (we already have these)
8. Click "Create repository"

## 2. Push Your Code to GitHub

After creating the repository, GitHub will show you commands. Use these:

```bash
# Add all files to git
git add .

# Create your first commit
git commit -m "Initial commit: URL Shortener Spring Boot application"

# Add your GitHub repository as origin (replace with your actual URL)
git remote add origin https://github.com/YOUR_USERNAME/url-shortener-spring-boot.git

# Push to GitHub
git branch -M main
git push -u origin main
```

## 3. Verify Your Repository

After pushing, your repository should have:

✅ All source code files  
✅ README with badges and documentation  
✅ LICENSE file  
✅ Contributing guidelines  
✅ GitHub issue templates  
✅ Pull request template  
✅ GitHub Actions CI workflow  
✅ .gitignore file  

## 4. Enable GitHub Actions

1. Go to your repository on GitHub
2. Click on the "Actions" tab
3. You should see the workflow already detected
4. GitHub Actions will now run automatically on pushes and pull requests

## 5. Configure Repository Settings (Optional)

Consider these settings for your repository:

1. **Add Topics**: Go to repository settings and add topics like:
   - `spring-boot`
   - `java`
   - `url-shortener`
   - `rest-api`
   - `learning-project`

2. **Enable Issues**: Make sure issues are enabled for bug reports and feature requests

3. **Set up Branch Protection** (for team projects):
   - Go to Settings → Branches
   - Add rule for `main` branch
   - Enable "Require pull request reviews before merging"

## 6. Add a Description and Website

1. Click the gear icon next to "About" on your repository page
2. Add a description
3. Add topics
4. If you deploy this app, add the URL

## Next Steps

- ⭐ Star your repository
- 📝 Create your first issue
- 🏷️ Create releases as you add features
- 📊 Check the Actions tab to see your CI pipeline in action

Congratulations! Your Spring Boot URL Shortener is now on GitHub! 🎉 