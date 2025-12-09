async function updateProductsUI(endpoint) {
  const container = document.querySelector("#product-list");

  const html = await fetch(endpoint).then((res) => res.text());

  container.innerHTML = html;
}
