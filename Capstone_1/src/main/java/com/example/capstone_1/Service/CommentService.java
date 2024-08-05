package com.example.capstone_1.Service;

import com.example.capstone_1.Model.Comment;
import com.example.capstone_1.Model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CommentService {

    ArrayList<Comment> comments = new ArrayList<>();

    final ProductService productService;

    final OrderService orderService;

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public String addComment(Comment comment) {
        for (Order order : orderService.getOrders()) {
            if (order.getUserId() == comment.getUserId()) {
                if (order.getProductId() == comment.getProductId()) {
                    comments.add(comment);
                    return "true";
                }
                return "Product does not exist";
            }
            return "User does not exist";
        }
        return "There is no Order";
    }

    public String updateComment(int id,Comment comment) {
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getId() == id) {
                for (Order order : orderService.getOrders()) {
                        if (order.getUserId() == comment.getUserId()) {
                            if (order.getProductId() == comment.getProductId()) {
                                comments.set(i,comment);
                                return "true";
                            }
                            return "Product does not exist";
                        }
                        return "User does not exist";
                }
                return "There is no Order";
            }
        }
        return "Comment does not exist";
    }
    public boolean deleteComment(int id) {
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getId() == id) {
                comments.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Comment> getCommentsByProductId(int productId) {
        ArrayList<Comment> commentsOfProduct = new ArrayList<>();
        for (Comment comment : comments) {
            if (comment.getProductId() == productId) {
                commentsOfProduct.add(comment);
            }
        }
        return commentsOfProduct;
    }

    public double getAverageRatingOfProduct(int productId) {
        double averageRating = 0;
        for (Comment comment : getCommentsByProductId(productId)) {
            averageRating += comment.getScore();
        }
        return averageRating / getCommentsByProductId(productId).size();
    }
}
