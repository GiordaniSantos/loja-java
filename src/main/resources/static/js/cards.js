async function removeProduct(button) {
  const id = button.dataset.id;
  const endpoint = button.dataset.endpoint;
  try {
    const response = await fetch(`/products/${id}`, {
      method: "DELETE",
    });

    if (!response.ok) {
      console.error("Erro ao remover produto");
      return;
    }

    updateProductsUI(endpoint || "/products");
  } catch (error) {
    console.error("Erro ao remover produto:", error);
  }
}

async function favoriteProduct(button) {
  const id = button.dataset.id;
  const endpoint = button.dataset.endpoint;
  try {
    const response = await fetch(`/products/${id}/favorite`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
    });

    if (!response.ok) {
      console.error("Erro ao favoritar produto");
      return;
    }

    updateProductsUI(endpoint || "/products");
  } catch (error) {
    console.error("Erro ao favoritar produto:", error);
  }
}
