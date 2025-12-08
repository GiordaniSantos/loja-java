async function updateProductsUI() {
  const container = document.querySelector("#product-list");

  const html = await fetch("/products").then((res) => res.text());

  container.innerHTML = html;
}
