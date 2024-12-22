function loadContent(url) {
    fetch(url)
        .then(response => response.text())
        .then(html => {
            document.getElementById('dynamic-content').innerHTML = html;
        })
        .catch(error => {
            console.log('Error loading content: ', error)
        });
}

function toggleSidebar() {
    const sidebar = document.getElementById('sidebar');
    sidebar.classList.toggle('collapsed');
    const content = document.querySelector('.content');
    content.style.marginLeft = sidebar.classList.contains('collapsed') ? '60px' : '250px';
}

