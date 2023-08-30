class customNav extends HTMLElement {
    element() {
      this.innerHTML = `<nav class="nav">
          <div class="logo">
            <h3 class="heading"><span>C</span>ypher</h3>
          </div>
          <div class="tabs">
            <ul class="elements">
              <li><a href="./home.html" class="nav-link">Home</a></li>
              <li><a href="../singUp/singUp.html" class="nav-link">Add</a></li>
              <li><a href="http://" class="nav-link">Update</a></li>
              <li><a href="http://" class="nav-link">Delete</a></li>
            </ul>
          </div>
          <button type="submit" class="btn btn-logout">Log out</button>
        </nav>`;
    }
  }
  
  customElements.define('custom-navigation',customNav);
